package com.epam.tc.hw7.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.pagecomponents.MetalsColorsForm;
import com.epam.tc.hw7.site.pagecomponents.ResultInfo;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsColorsPage extends WebPage {

    @Css("form[class=form]")
    public static MetalsColorsForm metalsColorsForm;

    @Css(".info-panel-body-result")
    private ResultInfo resultInfo;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }
}
