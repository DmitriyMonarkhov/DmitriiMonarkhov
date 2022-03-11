package com.epam.tc.hw6.components;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BenefitComponent extends AbstractComponent {

    public BenefitComponent(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "span[class^=\"icons-benefit\"]")
    private List<WebElement> benefitIcons;

    @FindBy(css = "span[class=\"benefit-txt\"]")
    private List<WebElement> benefitTexts;

    public int getNumberOfBenefitIcons() {
        return benefitIcons.size();
    }

    public int getNumberOfBenefitTexts() {
        return benefitTexts.size();
    }

    public List<WebElement> getBenefitIcons() {
        return benefitIcons;
    }

    public List<String> getBenefitTexts() {
        return benefitTexts
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
