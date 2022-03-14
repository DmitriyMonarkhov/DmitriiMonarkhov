package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.dataproviders.UserData.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiSite.homePage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;
import static com.epam.tc.hw7.site.pages.HomePage.userName;

import com.epam.tc.hw7.site.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        initSite(JdiSite.class);

        // Open HomePage
        homePage.open();
        // Open login form
        userIcon.click();
        // Login as Roman Iovlev
        loginForm.loginAs(DEFAULT_USER);
        // Assert that full login name is correct
        userName.is().text(DEFAULT_USER.fullName);
        // Check opened HomePage
        homePage.checkOpened();
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
