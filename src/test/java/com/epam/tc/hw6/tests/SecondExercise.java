package com.epam.tc.hw6.tests;


import com.epam.tc.hw6.steps.ActionSteps;
import com.epam.tc.hw6.steps.AssertionsSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SecondExercise extends BaseTest {

    @Feature("Testing of Different elements Page")
    @Story("The user logs in, goes to the Different elements page and selects various properties")
    @Test
    public void exercise_2_Test() {

        ActionSteps actionSteps = new ActionSteps(driver);
        AssertionsSteps assertionsSteps = new AssertionsSteps(driver);

        // Open test site by URL
        actionSteps.openWebPage();

        // Assert Browser title
        assertionsSteps.assertBrowserTitle(TITLE);

        // Perform login
        String login = properties.getString("login");
        String password = properties.getString("password");
        actionSteps.performLogin(login, password);

        // Assert Username in the left-top side of screen that user is loggined
        String username = properties.getString("username");
        assertionsSteps.assertUserName(username);

        // Open through the header menu Service -> Different Elements Page
        actionSteps.openServiceMenu();

        // Select checkboxes Water and Wind
        actionSteps.selectWaterAndWindCheckboxes();

        // Select radio Selen
        actionSteps.selectSelenRadio();

        // Select in dropdown Yellow
        actionSteps.selectYellowInDropdown();

        // Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        assertionsSteps.assertLogTexts(LOG_TEXTS);
    }
}
