package com.epam.latysheva;

/**
 * Created by Lidziya_Latyshava on 6/8/2017.
 */

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SumTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.out.println("SumTest starts its run");
        calculator = new Calculator();
        System.out.println("Calculator is created");
    }

    @AfterClass
    public void endLogging() {
        System.out.println("SumTest has been run");
    }

    @Test(dataProvider = "sumDoubleDataProvider", groups = {"arif", "all"})
    @Parameters({"double1", "double2", "expected"})
    public void sumTestDouble(double double1, double double2, double expected) {
        double sum = calculator.sum(double1, double2);
        Assert.assertEquals(sum, expected);
    }

    @DataProvider(name = "sumDoubleDataProvider")
    public Object[][] sumDoubleDataProvider() {
        return new Object[][]{
                {1.1, 2, 3.1},
                {0, 3.5, 3.5},
                {0.5, -3.5, -3},
                {-1, -39, -40},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "sumLongDataProvider", groups = {"arif", "all"})
    @Parameters({"long1", "long2", "expected"})
    public void sumTestLong(long long1, long long2, long expected) {
        long sum = calculator.sum(long1, long2);
        Assert.assertEquals(sum, expected);
    }

    @DataProvider(name = "sumLongDataProvider")
    public Object[][] sumLongDataProvider() {
        return new Object[][]{
                {5, 6, 11},
                {0, -4, -4},
                {6, -3, 3},
                {-10, 5, -5},
                {0, 0, 0}
        };
    }


}
