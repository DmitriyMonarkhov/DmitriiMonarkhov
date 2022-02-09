package hw1;

import hw1.dataProviders.DivideDP;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DivideTest extends SetUpTearDownCalc {

    @Test(
            dataProviderClass = DivideDP.class,
            dataProvider = "DP for divide operations"
    )
    public void divideTest(double numb1, double numb2, double expected) {
        double actual = calculator.div(numb1, numb2);
        assertEquals(actual, expected);
    }
    }