package com.epam.tc.hw4.tests;

import com.epam.tc.hw4.screnshotlistners.ScreenshotListener;
import com.epam.tc.hw4.steps.ActionSteps;
import com.epam.tc.hw4.steps.AssertionsSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class NegativeFirstExercise extends BaseTest {

    @Feature("Fail HomePage Test")
    @Story("Negative test with incorrect page assignment")
    @Test
    public void failureTest() {

        ActionSteps actionStepsFail = new ActionSteps(driver);
        AssertionsSteps assertionsStepsFail = new AssertionsSteps(driver);

        // Open test site by URL
        actionStepsFail.openWebPage();

        // Assert Browser title
        assertionsStepsFail.assertBrowserTitle("Google");

        // Perform login
        String login = properties.getString("login");
        String password = properties.getString("password");
        actionStepsFail.performLogin(login, password);

        // Assert Username in the left-top side of screen that user is loggined ("ROMAN IOVLEV")
        String username = properties.getString("username");
        assertionsStepsFail.assertUserName(username);

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionsStepsFail.assertFourHeaderItems(NAVIGATION_BAR_NAMES);

        // Assert that there are 4 images on the Index Page and they are displayed
        assertionsStepsFail.checkNumberOfBenefitTexts(NUMBER_OF_BENEFITS);
        assertionsStepsFail.checkBenefitImagesIsDisplayed();

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionsStepsFail.checkNumberOfBenefitTexts(BaseTest.NUMBER_OF_BENEFITS);
        assertionsStepsFail.checkBenefitTexts(BaseTest.BENEFIT_TEXTS);

        // Assert that there is the iframe with “Frame Button” exist
        assertionsStepsFail.assertIFrame();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        assertionsStepsFail.assertFrameButton();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionsStepsFail.assertFiveSideBarItems(LEFT_MENU_ITEMS);
    }
}
