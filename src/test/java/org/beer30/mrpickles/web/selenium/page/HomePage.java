package org.beer30.mrpickles.web.selenium.page;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 3/2/14
 *         Time: 8:24 PM
 */
public class HomePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private WebDriver webDriver;



    public HomePage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Welcome to Mr Pickles")) {
            throw new IllegalStateException("Requested HomePage: current page - " + webDriver.getTitle());
        }

    }
}
