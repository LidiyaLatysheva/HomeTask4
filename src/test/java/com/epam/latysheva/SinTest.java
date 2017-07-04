package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SinTest {

    @Test(dataProvider = "sinDoubleDataProvider", groups = {"trigo", "all"})
    @Parameters({"double1", "expected"})
    public void sinTestDouble(double double1, double expected) {
        Calculator calculator = new Calculator();
        double angleRad = (double1 * Math.PI) / 180;
        double sin = calculator.sin(angleRad);
        Assert.assertEquals(sin, expected, 0.001);
    }

    @DataProvider(name = "sinDoubleDataProvider")
    public Object[][] sinDoubleDataProvider() {
        return new Object[][]{
                {0, 0},
                {30, 0.5},
                {45, 0.707},
                {60, 0.866},
                {90, 1},
                {120, 0.866},
                {135, 0.707},
                {150, 0.5},
                {180, 0},
                {-30, -0.5},
                {-45, -0.707},
                {-60, -0.866},
                {-90, -1},
                {-120, -0.866},
                {-135, -0.707},
                {-150, -0.5},
                {-180, 0},
                {478, 0.883},
                {-478,- 0.883}
        };
    }


}
