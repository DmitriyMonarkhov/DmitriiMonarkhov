package hw1;

import hw1.dataProviders.MultiplyDP;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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