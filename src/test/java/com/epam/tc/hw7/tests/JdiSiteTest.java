package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.site.JdiSite.metalsColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.metalsColorsButton;
import static com.epam.tc.hw7.site.pages.MetalsColorsPage.metalsColorsForm;

import com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider;
import com.epam.tc.hw7.entities.MetalColorsEntity;
import org.testng.annotations.Test;

public class JdiSiteTest extends BaseTest {

    @Test(dataProvider = "metalsColorsObjects", dataProviderClass = MetalsColorsDataProvider.class)
    public void metalsAndColorsPageTest(MetalColorsEntity metalColorsEntity) {

        // Open Metals and Colors page
        metalsColorsButton.click();
        // Check that Metals and Colors page is opened
        metalsColorsPage.shouldBeOpened();
        // Fill checkboxes on Metals and Colors page
        metalsColorsForm.fill(metalColorsEntity);
        // Submit form Metals & Colors
        metalsColorsForm.submit();
        // Result sections should contain data which given as approved with hw7
        metalsColorsForm.verifyIfResultsAreCorrect(metalColorsEntity);
    }
}

