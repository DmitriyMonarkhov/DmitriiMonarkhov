package com.epam.tc.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw1.dataproviders.SumDP;
import org.testng.annotations.Test;

public class SumTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = SumDP.class,
            dataProvider = "DP for sum operations"
    )

    public void dataProviderSumTest(double numb1, double numb2, double expected) {
        double actual = calculator.sum(numb1, numb2);
        assertEquals(actual, expected);
    }
}
