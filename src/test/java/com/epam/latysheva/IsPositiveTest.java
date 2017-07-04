package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest {

    @Test(dataProvider = "isPosDataProvider", groups = {"all"})
    public void isPosTestDouble(long long1) {
        Calculator calculator = new Calculator();
        if (long1 > 0) {
            Assert.assertTrue(calculator.isPositive(long1));
        } else {
            Assert.assertFalse(calculator.isPositive(long1));
        }
    }

    @DataProvider(name = "isPosDataProvider")
    public Object[][] isPosDataProvider() {
        return new Object[][]{
                {0},
                {1},
                {-1}
        };
    }

}
