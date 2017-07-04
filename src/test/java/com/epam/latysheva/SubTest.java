package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubTest {

    @Test(dataProvider = "subDoubleDataProvider", groups = {"arif", "all"})
    @Parameters({"double1", "double2", "expected"})
    public void subTestDouble(double double1, double double2, double expected) {
        Calculator calculator = new Calculator();
        double sub = calculator.sub(double1, double2);
        Assert.assertEquals(sub, expected,0.01);
    }

    @DataProvider(name = "subDoubleDataProvider")
    public Object[][] subDoubleDataProvider() {
        return new Object[][]{
                {1.1, 2, -0.9},
                {0, 3.5, -3.5},
                {0.5, -3.5, 4},
                {-1, -39, 38},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "subLongDataProvider")
    @Parameters({"long1", "long2", "expected"})
    public void subTestLong(long long1, long long2, long expected) {
        Calculator calculator = new Calculator();
        long sub = calculator.sub(long1, long2);
        Assert.assertEquals(sub, expected);
    }

    @DataProvider(name = "subLongDataProvider")
    public Object[][] subLongDataProvider() {
        return new Object[][]{
                {5, 6, -1},
                {0, -4, 4},
                {6, -3, 9},
                {-10, 5, -15},
                {0, 0, 0}
        };
    }

}
