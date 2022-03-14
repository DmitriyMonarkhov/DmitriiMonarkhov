package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.site.pagecomponents.MetalsColorsForm;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {
    @Css("form[class=form]")
    public static MetalsColorsForm metalsColorsForm;

    @UI("ul.panel-body-list.results > li")
    public static List<Text> textRes;

    public static List<String> resultsListTransfer() {
        return textRes.stream().map(elem -> elem.getText()).collect(Collectors.toList());
    }
}

