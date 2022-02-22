package com.epam.tc.hw3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssertions softAssertions;
    protected WebDriverWait wait;
    protected Configuration properties;
    private final String data = "src/test/resources/hw3/data.properties";

    public WebDriver setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws ConfigurationException {
        driver = new BaseTest().setupDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        softAssertions = new SoftAssertions();
        properties = new PropertiesConfiguration(data);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
