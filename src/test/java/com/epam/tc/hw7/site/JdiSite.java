package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light")
public class JdiSite {

    public static HomePage homePage;

    public static MetalsColorsPage metalsColorsPage;
}

