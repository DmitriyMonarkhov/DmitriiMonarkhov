package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DivideDP {

    @DataProvider(name = "DP for divide operations")
    public Object[][] divideDP() {
        return new Object[][] {
                {34, 2, 17},
                {8, 8, 1},
                {5, 2, 2.5},
                {44, 1, 44},
                {34, 0, Double.POSITIVE_INFINITY}
        };
    }
}
