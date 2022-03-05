package com.epam.tc.hw5.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    // head menu
    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8")
    private List<WebElement> headMenuElement;
    @FindBy(xpath = "//div//ul/li[@class='dropdown']")
    private WebElement serviceButton;
    @FindBy(xpath = "//ul/li/ul/li/a[text()='User Table ']")
    private WebElement getServiceUserTable;

    // different elements menu
    @FindBy(xpath = "//a[text() = 'Different elements']")
    private WebElement getServiceDiffElementsHeadMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openByURL() {
        driver.navigate().to(URL);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnServiceDiffElementsHead() {
        headMenuElement.get(0).click();
        getServiceDiffElementsHeadMenu.click();
    }

    public void clickOnServiceOption() {
        serviceButton.click();
    }

    public void clickOnServiceUserTable() {
        getServiceUserTable.click();
    }
}
