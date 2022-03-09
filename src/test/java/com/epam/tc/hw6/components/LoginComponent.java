package com.epam.tc.hw6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginComponent extends AbstractComponent {

    @FindBy(id = "user-icon")
    private WebElement activationLoginProcedure;
    @FindBy(id = "name")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;

    public LoginComponent(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void performLogin(String login, String password) {
        activationLoginProcedure.click();
        loginInput.click();
        loginInput.sendKeys(login);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getLoggedInUserName() {
        return userName.getText();
    }
}
