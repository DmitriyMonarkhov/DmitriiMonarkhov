package com.epam.tc.hw6.tests;

import com.epam.tc.hw6.webdriver.WebDriverProvider;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String TITLE = "Home Page";
    public static final int NUMBER_OF_BENEFITS = 4;
    protected static final List<String> NAVIGATION_BAR_NAMES = Arrays
        .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> BENEFIT_TEXTS = Arrays.asList(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    protected static final List<String> LEFT_MENU_ITEMS = Arrays.asList("HOME\n"
        + "CONTACT FORM\n"
        + "SERVICE\n"
        + "METALS & COLORS");
    protected static final List<String> LOG_TEXTS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");

    protected WebDriver driver;
    protected SoftAssertions softAssertions;
    protected WebDriverWait wait;
    protected Configuration properties;
    private final String data = "src/test/resources/hw4/data.properties";


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() throws ConfigurationException {
        driver = WebDriverProvider.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        softAssertions = new SoftAssertions();
        properties = new PropertiesConfiguration(data);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        WebDriverProvider.closeDriver();
    }
}
