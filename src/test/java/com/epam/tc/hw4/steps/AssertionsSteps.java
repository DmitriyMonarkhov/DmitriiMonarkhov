package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.components.BenefitComponent;
import com.epam.tc.hw4.components.LoginComponent;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.tests.BaseTest;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AssertionsSteps extends BaseTest {

    protected HomePage homePage;
    protected LoginComponent loginPanel;
    protected BenefitComponent benefitComponent;
    protected DifferentElementsPage differentElementsPage;


    public AssertionsSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        loginPanel = new LoginComponent(driver);
        benefitComponent = new BenefitComponent(driver);
        differentElementsPage = new DifferentElementsPage(driver);

    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        String actualTitle = homePage.getTitle();
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined as ROMAN IOVLEV")
    public void assertUserName(String userName) {
        String actualName = loginPanel.getLoggedInUserName();
        Assertions.assertThat(actualName.equals(userName));
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertFourHeaderItems(List<String> expectedHeaderItemsList) {
        List<String> actualNavBarElements = homePage.getNavBarItemsNames();
        Integer expectedCountOfNavBarItems = NAVIGATION_BAR_NAMES.size();
        Integer actualCountOfNavBarItems = homePage.getNavBarItemsNames().size();
        Assertions.assertThat(expectedCountOfNavBarItems.equals(actualCountOfNavBarItems));
        for (String expectedNavBarItem : NAVIGATION_BAR_NAMES) {
            for (String actualNavBarItem : actualNavBarElements) {
                Assertions.assertThat(expectedNavBarItem.equals(actualNavBarItem));
            }
        }
    }

    @Step("Assert that images on the Index Page are displayed")
    public void checkBenefitImagesIsDisplayed() {
        benefitComponent.getBenefitIcons()
                .forEach(icon ->
                    Assertions
                        .assertThat(icon.isDisplayed())
                        .isTrue());
    }

    @Step("Assert that there are {expectedSize} texts on the Index Page under icons and they have proper text")
    public void checkNumberOfBenefitTexts(int expectedSize) {
        Assertions
            .assertThat(benefitComponent.getNumberOfBenefitTexts())
            .isEqualTo(expectedSize);
    }

    @Step("Assert that texts on the Index Page under icons have proper text: {expectedText}")
    public void checkBenefitTexts(List<String> expectedText) {
        Assertions
            .assertThat(benefitComponent.getBenefitTexts())
            .isEqualTo(expectedText);
    }

    @Step("Assert that there is the iframe")
    public void assertIFrame() {
        Assertions.assertThat(homePage.getFrameElement().isDisplayed());
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertFrameButton() {
        Assertions.assertThat(homePage.getFrameElement().isDisplayed());
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertFiveSideBarItems(List<String> expectedSideBarItems) {
        List<String> actualSideBarItems = homePage.getLeftSideBarItems();

        Integer expectedCountOfLeftSideBarItems = expectedSideBarItems.size();
        Integer actualCountOfLeftSideBarItems = actualSideBarItems.size();
        Assertions.assertThat(expectedCountOfLeftSideBarItems.equals(actualCountOfLeftSideBarItems));
        for (String expectedLeftSideBarItem : expectedSideBarItems) {
            for (String actualLeftSideBarItem : actualSideBarItems) {
                Assertions.assertThat(expectedLeftSideBarItem.equals(actualLeftSideBarItem));
            }
        }
    }

    @Step("Assert correct logTexts")
    public void assertLogTexts(List<String> expectedHeaderItemsList) {
        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogText : expectedHeaderItemsList) {

            for (String actualLogText : actualLogList) {
                Assertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }
    }

}
