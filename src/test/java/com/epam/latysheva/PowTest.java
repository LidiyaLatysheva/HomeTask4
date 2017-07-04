package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest {

    @Test(dataProvider = "powDoubleDataProvider", groups = {"arif", "all"})
    public void powTestDouble(double double1, double double2, double expected) {
        Calculator calculator = new Calculator();
        double pow = calculator.pow(double1, double2);
        Assert.assertEquals(pow, expected, 0.001);
    }

    @DataProvider(name = "powDoubleDataProvider")
    public Object[][] powDoubleDataProvider() {
        return new Object[][]{
                {1.1, 2, 1.21},
                {2, 3.5, 11.314},
                {0.5, -3, 8},
                {-1, -39, -1},
                {0, 0, 1},
                {3.2, 1.2, 4.038}
        };
    }

}
