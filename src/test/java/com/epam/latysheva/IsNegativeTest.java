package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest {

    @Test(dataProvider = "isNegDataProvider", groups = {"all"})
    public void isNegTestDouble(long long1) {
        Calculator calculator = new Calculator();
        if (long1 < 0) {
            Assert.assertTrue(calculator.isNegative(long1));
        } else {
            Assert.assertFalse(calculator.isNegative(long1));
        }
    }

    @DataProvider(name = "isNegDataProvider")
    public Object[][] isNegDataProvider() {
        return new Object[][]{
                {0},
                {1},
                {-1}
        };
    }

}
