package com.epam.tc.hw7.site.pagecomponents;

import static com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider.getColor;
import static com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider.getElements;
import static com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider.getMetal;
import static com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider.getSummary;
import static com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider.getVegetables;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.entities.MetalColorsEntity;
import com.epam.tc.hw7.site.JdiSite;
import java.util.List;

public class MetalsColorsForm extends Form<MetalColorsEntity> {

    @UI("[name=custom_radio_odd], [name=custom_radio_even]")
    public static RadioButtons summary;

    @FindBy(css = "section[class=vertical-group] input[type=checkbox]")
    public static Checklist elements;

    @JDropdown(root = ".colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = ".metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]", value = "button", list = "li", expand = ".caret")
    public static Dropdown vegetables;

    @Css("button#submit-button")
    public static Button submit;

    @Override
    public void fill(MetalColorsEntity metalColorsEntity) {

        List<String> listOfSummary = metalColorsEntity.summary;
        listOfSummary.stream().forEach(elem -> summary.select(String.valueOf(elem)));

        List<String> listOfElements = metalColorsEntity.elements;
        listOfElements.stream().forEach(elem -> elements.select(elem));

        color.select(metalColorsEntity.color);

        metals.select(metalColorsEntity.metals);

        vegetables.select("Vegetables");
        List<String> listOfVegetables = metalColorsEntity.vegetables;
        listOfVegetables.stream().forEach(elem -> vegetables.select(elem));
    }

    public void verifyIfResultsAreCorrect(MetalColorsEntity metalColorsEntity) {
        JdiSite.metalsColorsPage.getResultInfo().getColor().is().text(getColor(metalColorsEntity));
        JdiSite.metalsColorsPage.getResultInfo().getMetal().is().text(getMetal(metalColorsEntity));
        JdiSite.metalsColorsPage.getResultInfo().getElements().is().text(getElements(metalColorsEntity));
        JdiSite.metalsColorsPage.getResultInfo().getVegetables().is().text(getVegetables(metalColorsEntity));
        JdiSite.metalsColorsPage.getResultInfo().getSummary().is().text(getSummary(metalColorsEntity));
    }

    @Override
    public void submit() {
        submit.click();
    }
}
