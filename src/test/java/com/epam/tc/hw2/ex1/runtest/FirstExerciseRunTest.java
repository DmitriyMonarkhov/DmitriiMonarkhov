package com.epam.tc.hw2.ex1.runtest;

import com.epam.tc.hw2.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstExerciseRunTest extends DriverManager {

    private static final List<String> FOUR_IMAGES_TEXTS = Arrays.asList(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    @Test(
        description = "First exercise test"
    )
    public void exercise_1_Test() {

        // STEP 1. Open test site by URL
        driver.navigate().to(properties.getString("URL"));
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(properties.getString("URL"));

        //STEP 2. Assert Browser title
        softAssertions.assertThat(driver.getTitle()).isEqualTo(properties.getString("pageTitle"));

        //STEP 3. Perform login
        driver.findElement(By.id("user-icon"));
        driver.findElement(By.className("profile-photo")).click();
        driver.findElement(By.id("name")).sendKeys(properties.getString("login"));
        driver.findElement(By.id("password")).sendKeys(properties.getString("password"));
        driver.findElement(By.id("login-button")).click();

        //STEP 4. Assert User name in the left-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssertions.assertThat(userName.getText()).isEqualTo(properties.getString("username"));

        //STEP 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> header = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8"));
        List<String> textsHeader = header.stream().map(WebElement::getText).collect(Collectors.toList());
        softAssertions.assertThat(textsHeader).isEqualTo(Arrays.asList("HOME\n"
            + "CONTACT FORM\n"
            + "SERVICE\n"
            + "METALS & COLORS"));

        //STEP 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssertions.assertThat(driver.findElement(By.cssSelector(".icon-practise")).isDisplayed());
        softAssertions.assertThat(driver.findElement(By.cssSelector(".icon-custom")).isDisplayed());
        softAssertions.assertThat(driver.findElement(By.cssSelector(".icon-multi")).isDisplayed());
        softAssertions.assertThat(driver.findElement(By.cssSelector(".icon-base")).isDisplayed());

        //STEP 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> fourImagesText = driver.findElements(By.className("benefit-txt"));
        softAssertions.assertThat(fourImagesText.size()).isEqualTo(properties
            .getInt("amountOfTextsUnderImages"));

        for (int i = 0; i < properties.getInt("amountOfTextsUnderImages"); i++) {
            softAssertions.assertThat(fourImagesText.get(i).isDisplayed()).isTrue();
            softAssertions.assertThat(fourImagesText.get(i).getText())
                          .isEqualTo(FOUR_IMAGES_TEXTS.get(i));
        }

        //STEP 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        softAssertions.assertThat(iframe.isDisplayed()).isTrue();

        //STEP 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssertions.assertThat(frameButton.isDisplayed()).isTrue();

        //STEP 10. Switch to original window back
        driver.switchTo().defaultContent();
        softAssertions.assertThat(userName.isDisplayed()).isTrue();

        //STEP 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftBarElements = driver.findElements(By.cssSelector("ul.sidebar-menu > li"));
        List<String> textsLeftBarElements = leftBarElements.stream()
                                                           .map(WebElement::getText)
                                                           .collect(Collectors.toList());
        softAssertions.assertThat(textsLeftBarElements).isEqualTo(
            Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"));

        softAssertions.assertAll();
    }
}
