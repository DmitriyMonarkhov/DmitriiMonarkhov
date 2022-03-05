package com.epam.tc.hw5.components;

import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {

    protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }
}
