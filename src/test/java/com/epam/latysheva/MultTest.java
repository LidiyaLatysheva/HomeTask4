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

public class MultTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    private void setUp() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "multDoubleDataProvider")
    @Parameters({"double1", "double2", "expected"})
    public void multTestDouble(double double1, double double2, double expected) {
        double mult = calculator.mult(double1, double2);
        Assert.assertEquals(mult, expected, 0.001);
    }

    @DataProvider(name = "multDoubleDataProvider")
    public Object[][] multDoubleDataProvider() {
        return new Object[][]{
                {1.1, 2, 2.2},
                {0, 3.5, 0},
                {0.5, -3.5, -1.75},
                {-1, -39, 39},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "multLongDataProvider", groups = {"arif", "all"})
    @Parameters({"long1", "long2", "expected"})
    public void multTestLong(long long1, long long2, long expected) {
        long mult = calculator.mult(long1, long2);
        Assert.assertEquals(mult, expected);
    }

    @DataProvider(name = "multLongDataProvider")
    public Object[][] multLongDataProvider() {
        return new Object[][]{
                {5, 6, 30},
                {0, -4, 0},
                {6, -3, -18},
                {-10, 5, -50},
                {0, 0, 0}
        };
    }

}
