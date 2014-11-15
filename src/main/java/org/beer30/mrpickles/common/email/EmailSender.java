package org.beer30.mrpickles.common.email;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Low level Email Sending Util Class. Implements a way to override the outgoing email to address. This is extremely helpful
 * in testing with real data.
 *
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/23/13
 * Time: 2:58 PM
 */
public class EmailSender {

    private Logger log = LoggerFactory.getLogger(EmailSender.class);

    private String overrideEmail = "";
    private JavaMailSender mailSender;

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String getOverrideEmail() {
        return overrideEmail;
    }

    public void setOverrideEmail(String overrideEmail) {
        this.overrideEmail = overrideEmail;
    }

    public void sendMail(String from, String to[], String subject, String body, File attachment) {

        MimeMessage message = mailSender.createMimeMessage();

        try {

            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            helper.setFrom(from);
            helper.setTo(getToAddress(to));
            helper.setSubject(subject);
            helper.setText(body);

            if (attachment != null) {

                if (FilenameUtils.getExtension(attachment.getName()).equalsIgnoreCase("pgp")) {
                    helper.addAttachment(attachment.getName(),new FileSystemResource(attachment),"application/pgp-encrypted");
                } else {
                    helper.addAttachment(attachment.getName(),attachment);
                }
            }

        } catch (MessagingException ex) {
            throw new MailParseException(ex);
        }
        mailSender.send(message);
        //Log Email Sent
        try {
            String toList = ArrayUtils.toString(message.getAllRecipients());
            log.info("Email Sent to: " + toList + " - Subject: " + message.getSubject() + " Content: " + body );
        } catch (MessagingException e) {
            log.error("Error Logging Email",e);
        }
    }

    protected String[] getToAddress(String origTo[]) {
        if (overrideEmail.length() > 1) {
            log.info("Email Override: Originally sending to: " + ArrayUtils.toString(origTo) + " Override to: " + overrideEmail);
            String to[] = new String[1];
            to[0] = overrideEmail;
            return to;
        } else {
            return origTo;
        }
    }
}
