package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.utils.PropertiesFileReader;
import io.cucumber.java.en.When;

public class ActionSteps extends AbstractStep {

    @When("I open page Home Page")
    public void openWebPage() {
        homePage.openByURL();
    }

    @When("I login as user 'Roman Iovlev'")
    public void performLogin() {
        PropertiesFileReader propertiesFileReader = new PropertiesFileReader();
        String login = propertiesFileReader.getProperties("login");
        String password = propertiesFileReader.getProperties("password");
        loginComponent.performLogin(login, password);
    }

    @When("I click on 'Different Elements' subcategory in 'Service' button in Header menu")
    public void openServiceMenu() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @When("I select water checkbox on Different Elements Page")
    public void selectWaterCheckboxes() {
        differentElementsPage.selectWaterCheckBox();
    }

    @When("I select wind checkbox on Different Elements Page")
    public void selectWindCheckboxes() {
        differentElementsPage.selectWindCheckbox();
    }

    @When("I select selen radio button on Different Elements Page")
    public void selectSelenRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @When("I select yellow color from dropdown list on Different Elements Page")
    public void selectYellowInDropdown() {
        differentElementsPage.selectYellowInDropdown();
    }

    @When("I click on 'Service' button in Header")
    public void clickOnServiceOption() {
        homePage.clickOnServiceOption();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableOnServiceHead() {
        homePage.clickOnServiceUserTable();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickOnVipCheckboxForSergeyIvan() {
        userTablePage.setVipCheckboxForSergeyIvan();
    }
}

