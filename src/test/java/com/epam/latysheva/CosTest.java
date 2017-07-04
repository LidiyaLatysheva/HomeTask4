package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CosTest {

    @Test(dataProvider = "cosDoubleDataProvider", groups = {"trigo", "all"})
    @Parameters({"double1", "expected"})
    public void sinTestDouble(double double1, double expected) {
        Calculator calculator = new Calculator();
        double angleRad = (double1 * Math.PI) / 180;
        double cos = calculator.cos(angleRad);
        Assert.assertEquals(cos, expected, 0.001);
    }

    @DataProvider(name = "cosDoubleDataProvider")
    public Object[][] cosDoubleDataProvider() {
        return new Object[][]{
                {0, 1},
                {30, 0.866},
                {45, 0.707},
                {60, 0.5},
                {90, 0},
                {120, -0.5},
                {135, -0.707},
                {150, -0.866},
                {180, -1},
                {-30, 0.866},
                {-45, 0.707},
                {-60, 0.5},
                {-90, 0},
                {-120, -0.5},
                {-135, -0.707},
                {-150, -0.866},
                {-180, -1},
                {478, -0.47},
                {-478, 0.47}
        };
    }


}
