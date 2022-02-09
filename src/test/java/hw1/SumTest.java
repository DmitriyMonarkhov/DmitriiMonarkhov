package hw1;

import hw1.dataProviders.SumDP;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SumTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = SumDP.class,
            dataProvider = "DP for sum operations"
    )

    public void dataProviderSumTest(double numb1, double numb2, double expected) {
        double actual = calculator.sum (numb1, numb2);
        assertEquals(actual, expected);
    }
}
