package com.aleks.server.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class DivisionTest {

    private Command divisionCommand;

    @Before
    public void before() {
        divisionCommand = new Division();
    }

    @Test
    public void executeDivisionPositiveNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(20);
        BigDecimal twoNumber = new BigDecimal(5);
        BigDecimal expectedResult = new BigDecimal("4.000");
        assertEquals(expectedResult, divisionCommand.execute(oneNumber, twoNumber));
    }

    @Test
    public void executeDivisionNegativeNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(-20);
        BigDecimal twoNumber = new BigDecimal(-5);
        BigDecimal expectedResult = new BigDecimal("4.000");
        assertEquals(expectedResult, divisionCommand.execute(oneNumber, twoNumber));
    }

    @Test(expected = ArithmeticException.class)
    public void executeDivisionZeroTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(-20);
        BigDecimal twoNumber = new BigDecimal(0);
        divisionCommand.execute(oneNumber, twoNumber);
    }

}