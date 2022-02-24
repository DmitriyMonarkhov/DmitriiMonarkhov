package com.epam.tc.hw3.tests;

import static com.epam.tc.hw3.tests.DataClass.LOG_TEXTS;
import static com.epam.tc.hw3.tests.DataClass.TITLE;
import static com.epam.tc.hw3.tests.DataClass.URL;

import com.epam.tc.hw3.components.LoginComponent;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import java.util.List;
import org.testng.annotations.Test;

public class SecondExercise extends BaseTest {

    @Test
    public void exercise_2_Test() {

        // STEP 1. Open test site by URL
        driver.navigate().to(URL);

        //STEP 2. Assert Browser title
        softAssertions.assertThat(driver.getTitle()).isEqualTo(TITLE);

        //STEP 3. Perform login
        LoginComponent loginPage = new LoginComponent(driver);
        String login = properties.getString("login");
        String password = properties.getString("password");
        loginPage.performLogin(login, password);

        //STEP 4. Assert User name in the left-top side of screen that user is loggined
        String actualName = loginPage.getLoggedInUserName();
        String username = properties.getString("username");
        softAssertions.assertThat(actualName.equals(username));

        //STEP 5. Open through the header menu Service -> Different Elements Page click Service header menu
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnServiceDiffElementsHead();

        //STEP 6. Select checkboxes select checkbox with parameter Water and Wind
        differentElementsPage.selectWaterCheckBox();
        differentElementsPage.selectWindCheckbox();

        //STEP 7. Select radio
        differentElementsPage.selectSelenRadio();

        //STEP 8. Select in dropdown
        differentElementsPage.selectYellowInDropdown();

        //STEP 9. Assert that
        // - for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status
        // of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogText : LOG_TEXTS) {
            for (String actualLogText : actualLogList) {
                softAssertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }
        softAssertions.assertAll();
    }
}
