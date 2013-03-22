package org.beer30.mrpickles.web.controller;

import org.beer30.mrpickles.domain.entity.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RequestMapping("/home/**")
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index(Model model,Principal principal) {
        logger.debug("* * * * * * * * * * * * * * Home Controller - Enter * * * * * * * * * * * * * *");
        AppUser appUser = new AppUser();
        appUser.setUserName(principal.getName());
        model.addAttribute("appUser",appUser);
        return "home/index";
    }
}
