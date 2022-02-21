package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class DivideDP {

    @DataProvider(name = "DP for divide operations")
    public Object[][] divideDP() {
        return new Object[][] {
                {34, 2, 17},
                {8, 8, 1},
                {5, 2, 2.5},
                {44, 1, 44},
        };
    }

    @DataProvider(name = "DP for divide operation by zero")
    public Object[][] divideZeroDP() {
        return new Object[][] {
                {10, 0},
                {-20, 0},
                {120, 0},
                {11, -0}
        };
    }
}
