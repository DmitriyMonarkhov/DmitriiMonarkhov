package com.epam.tc.hw3.tests;

import static com.epam.tc.hw3.tests.DataClass.BENEFIT_TEXTS;
import static com.epam.tc.hw3.tests.DataClass.LEFT_MENU_ITEMS;
import static com.epam.tc.hw3.tests.DataClass.NUMBER_OF_BENEFITS;
import static com.epam.tc.hw3.tests.DataClass.TITLE;
import static com.epam.tc.hw3.tests.DataClass.URL;

import com.epam.tc.hw3.components.BenefitComponent;
import com.epam.tc.hw3.components.LoginComponent;
import com.epam.tc.hw3.pages.HomePage;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstExercise extends BaseTest {

    @Test
    public void exercise_1_Test() {

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

        //STEP 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        BenefitComponent benefitComponent = new BenefitComponent(driver);
        softAssertions
            .assertThat(benefitComponent.getNumberOfBenefitIcons())
            .isEqualTo(NUMBER_OF_BENEFITS);

        benefitComponent.getBenefitIcons()
                        .forEach(icon ->
                            softAssertions
                                .assertThat(icon.isDisplayed())
                                .isTrue());

        //STEP 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssertions
            .assertThat(benefitComponent.getNumberOfBenefitIcons())
            .isEqualTo(NUMBER_OF_BENEFITS);

        benefitComponent.getBenefitIcons().forEach(icon -> softAssertions
            .assertThat(icon.isDisplayed()).isTrue());

        //STEP 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions
            .assertThat(benefitComponent.getNumberOfBenefitTexts())
            .isEqualTo(NUMBER_OF_BENEFITS);

        softAssertions
            .assertThat(benefitComponent.getBenefitTextsTexts())
            .isEqualTo(BENEFIT_TEXTS);
        //STEP 8. Assert that there is the iframe with “Frame Button” exist
        HomePage homePage = new HomePage(driver);
        softAssertions.assertThat(homePage.getFrameElement().isEnabled());
        softAssertions.assertThat(homePage.getFrameElement().isDisplayed());
        WebElement iframe = homePage.getFrameElement();

        //STEP 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        String startWindowPage = driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        softAssertions.assertThat(homePage.getFrameButton().isEnabled());

        //STEP 10. Switch to original window back
        driver.switchTo().window(startWindowPage);

        //STEP 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> sideBarItems = homePage.getLeftSideBarItems();
        Integer expectedCountOfLeftSideBarItems = LEFT_MENU_ITEMS.size();
        Integer actualCountOfLeftSideBarItems = sideBarItems.size();
        softAssertions.assertThat(expectedCountOfLeftSideBarItems.equals(actualCountOfLeftSideBarItems));
        // check texts of items
        for (String expectedLeftSideBarItem : LEFT_MENU_ITEMS) {
            for (String actualLeftSideBarItem : sideBarItems) {
                softAssertions.assertThat(expectedLeftSideBarItem.equals(actualLeftSideBarItem));
            }
        }
        softAssertions.assertAll();
    }
}
