package com.aleks.server.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class MultiplyTest {

    private Command multiplyCommand;

    @Before
    public void before() {
        multiplyCommand = new Multiply();
    }

    @Test
    public void executeMultiplyPositiveNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(2);
        BigDecimal twoNumber = new BigDecimal(8);
        BigDecimal expectedResult = new BigDecimal(16);
        assertEquals(expectedResult, multiplyCommand.execute(oneNumber, twoNumber));
    }

    @Test
    public void executeMultiplyNegativeNumberTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(-3);
        BigDecimal twoNumber = new BigDecimal(8);
        BigDecimal expectedResult = new BigDecimal(-24);
        assertEquals(expectedResult, multiplyCommand.execute(oneNumber, twoNumber));
    }
}