package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class SubtractDP {
    @DataProvider(name = "DP for subtract operations")
    public Object[][] subtractDP() {
        return new Object[][] {
                {33, 33, 0},
                {1, 5, -4},
                {0, 0, 0},
                {-32, 0, -32},
                {1, 0, 1}
        };
    }
}