package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.components.LoginComponent;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionSteps {

    protected HomePage homePage;
    protected LoginComponent loginPanel;
    protected DifferentElementsPage differentElementsPage;

    public ActionSteps(WebDriver driver) {
        differentElementsPage = new DifferentElementsPage(driver);
        homePage = new HomePage(driver);
        loginPanel = new LoginComponent(driver);
    }

    @Step("Open test site by URL")
    public void openWebPage() {
        homePage.openByURL();
    }

    @Step("Perform login")
    public void performLogin(String login, String password) {
        loginPanel.performLogin(login, password);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openServiceMenu() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @Step("Select checkboxes Water and Wind")
    public void selectWaterAndWindCheckboxes() {
        differentElementsPage.selectWaterCheckBox();
        differentElementsPage.selectWindCheckbox();
    }

    @Step("Select radio Selen")
    public void selectSelenRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @Step("Select in dropdown Yellow")
    public void selectYellowInDropdown() {
        differentElementsPage.selectYellowInDropdown();
    }


}
