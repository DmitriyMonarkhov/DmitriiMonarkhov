package com.epam.tc.hw2.ex2.runtest;

import com.epam.tc.hw2.BaseTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SecondExercise extends BaseTest {

    private static final List<String> CHOSEN_OPTIONS = new ArrayList<>(
        Arrays.asList("Colors: value changed to Yellow", "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
        ));

    @Test(
        description = "Second exercise test"
    )
    public void exercise_2_Test() {

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

        //STEP 5. Open through the header menu Service -> Different Elements Page click Service header menu
        WebElement serviceUpMenu = driver.findElement(By.className("dropdown-toggle"));
        serviceUpMenu.click();
        serviceUpMenu.findElement(By.xpath("//a[text() = 'Different elements']")).click();
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(properties.getString("URLDifferentElementPage"));

        //STEP 6. Select checkboxes select checkbox with parameter Water and Wind
        WebElement waterCheckBox = driver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input"));
        waterCheckBox.click();
        WebElement windCheckBox = driver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input"));
        windCheckBox.click();
        softAssertions.assertThat(waterCheckBox.isSelected()).isTrue();
        softAssertions.assertThat(windCheckBox.isSelected()).isTrue();

        //STEP 7. Select radio
        WebElement radio = driver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input"));
        radio.click();
        softAssertions.assertThat(radio.isSelected()).isTrue();

        //STEP 8. Select in dropdown
        WebElement dropdown = driver.findElement(By.tagName("select"));
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='Yellow']")).click();

        //STEP 9. Assert that
        // - for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox
        // - for radio button there is a log row and value is corresponded to the status
        // of radio button
        // - for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> actualLog = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
        for (int i = 0; i < CHOSEN_OPTIONS.size(); i++) {
            softAssertions.assertThat(actualLog.get(i).getText()).contains(CHOSEN_OPTIONS.get(i));
        }
        softAssertions.assertAll();
    }
}
