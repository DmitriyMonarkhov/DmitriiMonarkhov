package com.epam.tc.hw4.pages;

import java.util.ArrayList;
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

    // side-bar
    @FindBy(css = "ul.sidebar-menu > li")
    private List<WebElement> leftSideBarItems;

    // frame
    @FindBy(id = "frame")
    private WebElement frame;

    // frame button
    @FindBy(id = "frame-button")
    private WebElement frameButton;

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

    public List<String> getNavBarItemsNames() {
        List<String> navBarItemsList = new ArrayList<>();
        for (WebElement navBarItem : headMenuElement) {
            navBarItemsList.add(navBarItem.getText());
        }
        return navBarItemsList;
    }

    public WebElement getFrameElement() {
        return frame;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<String> getLeftSideBarItems() {
        List<String> leftSideBarItemsList = new ArrayList<>();
        for (WebElement leftBarItem : leftSideBarItems) {
            leftSideBarItemsList.add(leftBarItem.getText());
        }
        return leftSideBarItemsList;
    }

    public void clickOnServiceDiffElementsHead() {
        headMenuElement.get(0).click();
        getServiceDiffElementsHeadMenu.click();
    }
}
