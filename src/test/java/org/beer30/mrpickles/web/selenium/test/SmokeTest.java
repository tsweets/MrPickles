package org.beer30.mrpickles.web.selenium.test;

import org.beer30.mrpickles.web.selenium.page.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 3/2/14
 *         Time: 8:29 PM
 */
public class SmokeTest {
    private static final Logger log = LoggerFactory.getLogger(SmokeTest.class);
    private static String testSite = "http://localhost:8888";

    @Before
    public void setup() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void smokeMrPickles() {
        WebDriver webDriver = new HtmlUnitDriver();

        log.info("Requesting HomePage");

        webDriver.get(testSite);
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        Assert.assertNotNull(homePage);
/*
        log.info("Requesting Privacy Policy");
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicyLink();
        Assert.assertNotNull(privacyPolicyPage);

        // If I go back I should be at the home page again
        log.info("Hitting the Back button");
        webDriver.navigate().back();
        HomePage homePageAfterBack = PageFactory.initElements(webDriver, HomePage.class);
        Assert.assertNotNull(homePageAfterBack);

        // Search for Nissan
        log.info("Looking up Nissan Motor Company");
        NissanPage nissanPage = homePageAfterBack.searchForNissan();
        Assert.assertNotNull(nissanPage);

        // Goto the List of Nissan Cars
        log.info("Clicking List of Nissan Cars");
        NissanCarListPage nissanCarListPage = nissanPage.selectListOfCars();
        Assert.assertNotNull(nissanCarListPage);

        // Finally goto the Nissan Skyline GT-R Page
        log.info("Clicking Skyline GT-R");
        NissanSkylinePage nissanSkylinePage = nissanCarListPage.selectNissanSkyline();
        Assert.assertNotNull(nissanSkylinePage);
*/

        webDriver.quit();

    }
}
