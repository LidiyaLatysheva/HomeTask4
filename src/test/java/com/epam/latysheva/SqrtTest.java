package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SqrtTest {

    @Test(dataProvider = "sqrtDoubleDataProvider")
    @Parameters({"double1", "expected"})
    public void sqrtTestDouble(double double1, double expected) {
        Calculator calculator = new Calculator();
        double sqrt = calculator.sqrt(double1);
        Assert.assertEquals(sqrt, expected, 0.001);
    }

    @DataProvider(name = "sqrtDoubleDataProvider")
    public Object[][] sqrtDoubleDataProvider() {
        return new Object[][]{
                {1.1, 1.049},
                {4,2},
                {0,0},
                {1,1},
                {1.21, 1.1},
                {3.24, 1.8}
        };
    }


    @Test(dataProvider = "sqrtDoubleNegativeDataProvider")
    @Parameters({"double1", "expected"})
    public void sqrtTestDoubleNeg(double double1) {
        Calculator calculator = new Calculator();
        double sqrt = calculator.sqrt(double1);
        Assert.assertTrue(Double.isNaN(sqrt));
    }
    @DataProvider(name = "sqrtDoubleNegativeDataProvider")
    public Object[][] sqrtDoubleNegativeDataProvider() {
        return new Object[][]{
                {-1},
                {-4},
                {-9}
        };
    }
}
