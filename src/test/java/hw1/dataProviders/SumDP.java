package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class SumDP {
    @DataProvider(name = "DP for sum operations")
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {1, 1, 2},
                {-3, 3, 0},
                {-200, 100, -100},
                {0, 0, 0},
                {24, 0, 24}
        };
    }
}
