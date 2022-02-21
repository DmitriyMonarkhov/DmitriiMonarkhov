package com.epam.tc.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw1.dataproviders.SubtractDP;
import org.testng.annotations.Test;

public class SubtractTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = SubtractDP.class,
            dataProvider = "DP for subtract operations"
    )

    public void dataProvSubtractionTest(double numb1, double numb2, double expected) {
        double actual = calculator.sub(numb1, numb2);
        assertEquals(actual, expected);
    }
}
