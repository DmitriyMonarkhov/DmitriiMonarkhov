package com.epam.tc.hw1.dataproviders;

import org.testng.annotations.DataProvider;

public class MultiplyDP {
    @DataProvider(name = "DP for multiply operations")
    public Object[][] multiplyDP() {
        return new Object[][] {
                {1, 1, 1},
                {5, 0, 0},
                {100, 20, 2000},
                {-4, 3, -12},
                {-55, -2, 110}
        };
    }
}
