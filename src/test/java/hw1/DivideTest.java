package hw1;

import hw1.dataProviders.DivideDP;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivideTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = DivideDP.class,
            dataProvider = "DP for divide operations"
    )
    public void divideTest(double numb1, double numb2, double expected) {
        double actual = calculator.div(numb1, numb2);
        assertEquals(actual, expected);
    }

    @Test (
            expectedExceptions = NumberFormatException.class,
            dataProviderClass = DivideDP.class,
            dataProvider = "DP for divide operation by zero"
    )
    public void divideByZeroTest(long a, long b) {
        calculator.div(a, b);
    }
    }
