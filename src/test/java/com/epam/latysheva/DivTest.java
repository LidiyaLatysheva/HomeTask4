package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    private void setUp() {
        calculator = new Calculator();
    }


    @Test(dataProvider = "divDoubleDataProvider", groups = {"arif", "all"})
    @Parameters({"double1", "double2", "expected"})
    public void divTestDouble(double double1, double double2, double expected) {
        double div = calculator.div(double1, double2);
        Assert.assertEquals(div, expected, 0.001);
    }

    @DataProvider(name = "divDoubleDataProvider")
    public Object[][] divDoubleDataProvider() {
        return new Object[][]{
                {1.1, 2, 0.55},
                {0, 3.5, 0},
                {0.5, -3.5, -0.143},
                {-1, -5, 0.2}
        };
    }


    @Test( groups = {"arif", "all"})
    public void divByZeroTestDouble() {
        double double1 = -3;
        double double2 = 0;
        double div = calculator.div(double1, double2);
        System.out.println(div);
        Assert.assertTrue(Double.isInfinite(div));
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divByZeroTestLong() {
        long double1 = -3;
        long double2 = 0;
        long div = calculator.div(double1, double2);
    }

    @Test(dataProvider = "divLongDataProvider", groups = {"arif", "all"})
    @Parameters({"long1", "long2", "expected"})
    public void divTestLong(long long1, long long2, long expected) {
        long div = calculator.div(long1, long2);
        Assert.assertEquals(div, expected);
    }

    @DataProvider(name = "divLongDataProvider")
    public Object[][] divLongDataProvider() {
        return new Object[][]{
                {5, 6, 0},
                {0, -4, 0},
                {6, -3, -2},
                {-10, 5, -2}
        };
    }

}
