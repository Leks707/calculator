package com.aleks.server.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class MinusTest {

    private Command minusCommand;

    @Before
    public void before() {
        minusCommand = new Minus();
    }

    @Test
    public void executeMinusPositiveNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(1);
        BigDecimal twoNumber = new BigDecimal(8);
        BigDecimal expectedResult = new BigDecimal("-7");
        assertEquals(expectedResult, minusCommand.execute(oneNumber, twoNumber));
    }

    @Test
    public void executeMinusNegativeNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(-1);
        BigDecimal twoNumber = new BigDecimal(-8);
        BigDecimal expectedResult = new BigDecimal(7);
        assertEquals(expectedResult, minusCommand.execute(oneNumber, twoNumber));
    }
}