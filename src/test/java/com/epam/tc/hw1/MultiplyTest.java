package com.epam.tc.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw1.dataproviders.MultiplyDP;
import org.testng.annotations.Test;

public class MultiplyTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = MultiplyDP.class,
            dataProvider = "DP for multiply operations"
    )

    public void multiplyTest(double numb1, double numb2, double expected) {
        double actual = calculator.mult(numb1, numb2);
        assertEquals(actual, expected);
    }
}
