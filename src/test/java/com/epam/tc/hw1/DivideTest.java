package com.epam.tc.hw1;

import static org.testng.Assert.assertEquals;

import com.epam.tc.hw1.dataproviders.DivideDP;
import org.testng.annotations.Test;

public class DivideTest extends SetUpTearDownCalc {

    @Test(
        dataProviderClass = DivideDP.class,
        dataProvider = "DP for divide operations"
    )
    public void divideTest(double numb1, double numb2, double expected) {
        double actual = calculator.div(numb1, numb2);
        assertEquals(actual, expected);
    }

    @Test(
        expectedExceptions = NumberFormatException.class,
        dataProviderClass = DivideDP.class,
        dataProvider = "DP for divide operation by zero"
    )
    public void divideByZeroTest(long a, long b) {
        calculator.div(a, b);
    }
}
