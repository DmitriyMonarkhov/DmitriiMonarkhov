package com.epam.tc.hw3.tests;

import java.util.Arrays;
import java.util.List;

public class DataClass {

    protected static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String TITLE = "Home Page";
    public static final int NUMBER_OF_BENEFITS = 4;
    protected static final List<String> NAVIGATION_BAR_NAMES = Arrays
        .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> BENEFIT_TEXTS = Arrays.asList(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    protected static final List<String> LEFT_MENU_ITEMS = Arrays.asList("HOME\n"
        + "CONTACT FORM\n"
        + "SERVICE\n"
        + "METALS & COLORS");
    protected static final List<String> LOG_TEXTS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");
}
