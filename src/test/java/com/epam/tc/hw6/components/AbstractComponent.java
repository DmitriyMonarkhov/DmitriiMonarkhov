package com.epam.tc.hw6.components;

import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent {

    protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }
}
