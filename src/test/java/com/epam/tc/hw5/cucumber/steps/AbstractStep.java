package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.components.LoginComponent;
import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserTablePage;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AbstractStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected LoginComponent loginComponent;
    protected UserTablePage userTablePage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        loginComponent = new LoginComponent(driver);
        userTablePage = new UserTablePage(driver);
    }

    protected static final List<String> LOG_TEXTS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");
}
