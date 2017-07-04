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

public class CtgTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "ctgDoubleDataProvider", groups = {"trigo", "all"})
    @Parameters({"double1", "expected"})
    public void ctgTestDouble(double double1, double expected) {
        double angleRad = (double1 * Math.PI) / 180;
        double ctg = calculator.ctg(angleRad);
        Assert.assertEquals(ctg, expected, 0.001);
    }

    @DataProvider(name = "ctgDoubleDataProvider")
    public Object[][] ctgDoubleDataProvider() {
        return new Object[][]{
                {90, 0},
                {60, 0.577},
                {45, 1},
                {30 / 3, 1.732},
                {-60, -0.577},
                {-45 / 4, -1},
                {-30, -1.732},
                {562, 2.475},
                {-562, -2.475}
        };
    }

    //TODO think how to check
    @Test(dataProvider = "ctgNegDataProvider", groups = {"trigo", "all"})
    public void ctgTestNegative(double double1) {
        double angleRad = (double1 * Math.PI) / 180;
        double ctg = calculator.ctg(angleRad);
        Assert.assertTrue(Double.isInfinite(ctg));
    }

    @DataProvider(name = "ctgNegDataProvider")
    public Object[][] ctgNegDataProvider() {
        return new Object[][]{
                {0},
                {180},
                {-180}
        };
    }

}
