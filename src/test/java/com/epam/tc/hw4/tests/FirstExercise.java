package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.steps.FirstExerciseSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FirstExercise extends BaseTest {

    @Feature("Testing of Home  Page")
    @Story("The user logs in to the web page and interacts with its various elements "
        + "in to webpage and select elements on the page")
    @Test
    public void exercise_1_Test() {

        FirstExerciseSteps steps = new FirstExerciseSteps(driver);

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

        // Assert that there are 4 items on the header section are displayed and have proper texts
        steps.assertFourHeaderItems(NAVIGATION_BAR_NAMES);

        // Assert that there are 4 images on the Index Page and has are displayed
        steps.checkNumberOfBenefitTexts(NUMBER_OF_BENEFITS);
        steps.checkBenefitImagesIsDisplayed();

        // Assert that there are 4 texts on the Index Page under icons and has proper text
        steps.checkNumberOfBenefitTexts(BaseTest.NUMBER_OF_BENEFITS);
        steps.checkBenefitTexts(BaseTest.BENEFIT_TEXTS);

        // Assert that there is the iframe with “Frame Button” exist
        steps.assertIFrame();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        steps.assertFrameButton();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        steps.assertFiveSideBarItems(LEFT_MENU_ITEMS);
    }
}
