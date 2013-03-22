package org.beer30.mrpickles.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SiteLandingController {
	
	private static final Logger logger = LoggerFactory.getLogger(SiteLandingController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(value = "message", required = false) String message, Locale locale, Model model) {
		logger.info("Welcome to Mr Pickles - Home Page! The client locale is {}.", locale);

        if (message != null) {
            if (message.equalsIgnoreCase("error")) {
                model.addAttribute("error",true);
                model.addAttribute("errorMessage","Oh Shit!");
            } else if (message.equalsIgnoreCase("alert")) {
                model.addAttribute("alert",true);
                model.addAttribute("alertMessage","ALERT: Something is happening");
            } else if (message.equalsIgnoreCase("success")) {
                model.addAttribute("success",true);
                model.addAttribute("successMessage","Sweet! Whatever you were doing, it worked!");
            } else if (message.equalsIgnoreCase("info")) {
                model.addAttribute("info",true);
                model.addAttribute("infoMessage","Just wanted to let you, Mr Pickles is loose");
            } else if (message.equalsIgnoreCase("infoWithAction")) {
                model.addAttribute("infoWithAction",true);
                model.addAttribute("infoWithActionHeading","You Need to Go Somewhere else");
                model.addAttribute("infoWithActionContent","This is an Information Message with an Action");
                model.addAttribute("infoWithActionPrimaryAction","Goto Google");
                model.addAttribute("infoWithActionPrimaryActionLink","http://www.google.com");
                model.addAttribute("infoWithActionSecAction","Goto CNN");
                model.addAttribute("infoWithActionSecActionLink","http://www.cnn.com");
           }
        }
		
		return "homePage";
	}
	
}
