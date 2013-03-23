package org.beer30.mrpickles.common.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.app.VelocityEngine;
import org.beer30.mrpickles.domain.entity.AppUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: tsweets
 * Date: 3/23/13
 * Time: 3:22 PM
 */
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext-email.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailSenderTest {

    private final static Logger logger = LoggerFactory.getLogger(EmailSenderTest.class);

    private File attachment = new File("/tmp/attach.txt");
    private String random;

    private GreenMail greenMail;

    private static final String FROM_ADDR = "tsweets@example.net";


    @Autowired
    EmailSender mailSender;

    @Autowired
    private VelocityEngine velocityEngine;


    @Before
    public void setup() throws Exception {


        greenMail = new GreenMail(ServerSetupTest.SMTP);

        greenMail.start();

        FileUtils.deleteQuietly(attachment);
        ArrayList testLines = new ArrayList();
        random = GreenMailUtil.random();
        testLines.add(random);
        testLines.add("Test: " + Calendar.getInstance().getTime());
        FileUtils.writeLines(attachment,testLines);

    }

    @After
    public void tearDown(){
        greenMail.stop();
    }

    @Test
    public void sendEmailTest() throws InterruptedException, MessagingException, IOException {
        boolean success = false;
        String mailSubject = "This is a test";
        String mailBody= "Testing 1.2.3....";

        String to[] = {"tsweets@example.net"};
        mailSender.sendMail(FROM_ADDR,to,mailSubject,mailBody,attachment);

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(mailSubject, messages[0].getSubject());
        assertTrue(messages[0].getContent() instanceof MimeMultipart);
        MimeMultipart mp = (MimeMultipart) messages[0].getContent();
        assertEquals(2, mp.getCount());

        String body = GreenMailUtil.getBody(mp.getBodyPart(0)).trim();

        assertTrue(body.contains(mailBody));
        String attachmentText =  GreenMailUtil.getBody(mp.getBodyPart(1)).trim();

        assertTrue(attachmentText.contains(random));

        success = true;
        assertTrue(success);
    }

    @Test
    public void sendVelocityEmail() {
        AppUser user = new AppUser();
        user.setUserName("tsweets");
        user.setEmail("tsweets@example.com");

        String to[] = {"tsweets@example.net"};
        Map model = new HashMap();
        model.put("user",user);
        String mailBody = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/META-INF/emails/welcome-email.vm","UTF-8", model);

        mailSender.sendMail(FROM_ADDR,to,"Velocity Email",mailBody,attachment);

    }

}
