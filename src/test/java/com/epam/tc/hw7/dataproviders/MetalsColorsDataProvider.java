package com.epam.tc.hw7.dataproviders;

import com.epam.tc.hw7.entities.MetalColorsEntity;
import com.epam.tc.hw7.util.GoogleJsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;

public class MetalsColorsDataProvider {

    @DataProvider(name = "metalsColorsObjects")
    public static Object[][] metalsColorsObjects() throws IOException {
        InputStream inputStream = MetalsColorsDataProvider
                .class.getResourceAsStream("/hw7/JDI_ex8_metalsColorsDataSet.json");
        String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        return GoogleJsonParser.metalsColorsDataSetParser(text);
    }

    public static String getSummary(MetalColorsEntity metalsColorsData) {
        return String.format("Summary: %d",
                Integer.parseInt(metalsColorsData.summary.get(0))
                        + Integer.parseInt(metalsColorsData.summary.get(1)));
    }

    public static String getElements(MetalColorsEntity metalsColorsData) {
        return String.format("Elements: %s",
                String.join(", ", metalsColorsData.elements.toArray(String[]::new)));
    }

    public static String getColor(MetalColorsEntity metalsColorsData) {
        return String.format("Color: %s", metalsColorsData.color);
    }

    public static String getMetal(MetalColorsEntity metalsColorsData) {
        return String.format("Metal: %s", metalsColorsData.metals);
    }

    public static String getVegetables(MetalColorsEntity metalsColorsData) {
        return String.format("Vegetables: %s", String.join(", ", metalsColorsData.vegetables.toArray(String[]::new)));
    }
}
