package com.aleks.server.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class PlusTest {

    private Command plusCommand;

    @Before
    public void before() {
        plusCommand = new Plus();
    }

    @Test
    public void executePlusPositiveNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(1);
        BigDecimal twoNumber = new BigDecimal(8);
        BigDecimal expectedResult = new BigDecimal("9");
        assertEquals(expectedResult, plusCommand.execute(oneNumber, twoNumber));
    }

    @Test
    public void executePlusNegativeNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(-1);
        BigDecimal twoNumber = new BigDecimal(-8);
        BigDecimal expectedResult = new BigDecimal(-9);
        assertEquals(expectedResult, plusCommand.execute(oneNumber, twoNumber));
    }

}