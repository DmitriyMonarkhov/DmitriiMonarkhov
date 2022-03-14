package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiSite {

    @Url("/") @Title("Home Page")
    public static HomePage homePage;

    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static MetalsColorsPage metalsColorsPage;
}

