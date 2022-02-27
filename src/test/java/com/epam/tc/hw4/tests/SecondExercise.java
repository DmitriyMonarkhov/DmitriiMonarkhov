package com.epam.tc.hw4.tests;


import com.epam.tc.hw4.steps.SecondExerciseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SecondExercise extends BaseTest {

    @Feature("Testing of Different elements Page")
    @Story("The user logs in, goes to the Different elements page and selects various properties")
    @Test
    public void exercise_2_Test() {

        SecondExerciseSteps steps = new SecondExerciseSteps(driver);

        // Open test site by URL
        steps.openWebPage(driver);

        // Assert Browser title
        steps.assertBrowserTitle(TITLE);

        // Perform login
        String login = properties.getString("login");
        String password = properties.getString("password");
        steps.performLogin(login, password);

        // Assert Username in the left-top side of screen that user is loggined
        String username = properties.getString("username");
        steps.assertUserName(username);

        // Open through the header menu Service -> Different Elements Page
        steps.openServiceMenu();

        // Select checkboxes Water and Wind
        steps.selectWaterAndWindCheckboxes();

        // Select radio Selen
        steps.selectSelenRadio();

        // Select in dropdown Yellow
        steps.selectYellowInDropdown();

        // Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        steps.assertLogTexts(LOG_TEXTS);
    }
}
