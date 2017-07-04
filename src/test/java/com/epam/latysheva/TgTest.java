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

public class TgTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    private void setUp() {
        calculator = new Calculator();
    }

    @Test(dataProvider = "tgDoubleDataProvider", groups = {"trigo", "all"})
    @Parameters({"double1", "expected"})
    public void tgTestDouble(double double1, double expected) {
        double angleRad = (double1 * Math.PI) / 180;
        double tg = calculator.tg(angleRad);
        Assert.assertEquals(tg, expected, 0.001);
    }

    @DataProvider(name = "tgDoubleDataProvider")
    public Object[][] tgDoubleDataProvider() {
        return new Object[][]{
                {0, 0},
                {30, 0.577},
                {45, 1},
                {60 / 3, 1.732},
                {-30, -0.577},
                {-45 / 4, -1},
                {-60, -1.732},
                {562, 0.404},
                {-562, -0.404}
        };
    }

    //TODO think how to check
    @Test(dataProvider = "tgNegDataProvider", groups = {"trigo", "all"})
    public void tgTestNegative(double double1) {
        double angleRad = Math.toRadians(double1);
        double tg = calculator.tg(angleRad);
        double angleRad1 = (double1 * Math.PI) / 180;
        System.out.println("double1=" + double1 + "    angleRad="+angleRad+ "    angleRad1="+angleRad1);
        System.out.println("tg=" + tg);
        System.out.println("Math.tan=" + Math.tan(angleRad));
        Assert.assertTrue(Double.isInfinite(tg));
    }

    @DataProvider(name = "tgNegDataProvider")
    public Object[][] tgNegDataProvider() {
        return new Object[][]{
                {90},
                {270},
                {-90},
                {-270}
        };
    }

}
