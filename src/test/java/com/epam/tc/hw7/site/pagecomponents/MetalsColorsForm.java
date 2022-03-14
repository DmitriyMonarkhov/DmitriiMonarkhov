package com.epam.tc.hw7.site.pagecomponents;

import static com.epam.tc.hw7.site.pages.MetalsColorsPage.resultsListTransfer;

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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;

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

        List<Integer> listOfSummary = metalColorsEntity.summary;
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

        int summary = metalColorsEntity.summary.get(0) + metalColorsEntity.summary.get(1);

        List<String> listOfElements = metalColorsEntity.elements;
        String stringOfElements = listOfElements.stream().collect(Collectors.joining(", "));

        List<String> listOfVegetables = metalColorsEntity.vegetables;
        String stringOfVegetables = listOfVegetables.stream().collect(Collectors.joining(", "));

        List<String> expectedResult = Arrays.asList(
                "Summary: " + String.valueOf(summary), "Elements: " + stringOfElements,
                "Color: " + metalColorsEntity.color,
                "Metal: " + metalColorsEntity.metals, "Vegetables: " + stringOfVegetables
        );

        List<String> actualResult = resultsListTransfer();

        SoftAssertions soft = new SoftAssertions();

        soft.assertThat(actualResult)
                .as("Expected results in 'Result section' are not equal to actual results")
                .isEqualTo(expectedResult);

    }

    @Override
    public void submit() {
        submit.click();
    }
}
