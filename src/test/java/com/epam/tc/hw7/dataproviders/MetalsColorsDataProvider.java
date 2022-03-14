package com.epam.tc.hw7.dataproviders;

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
}
