package com.aleks.server.command;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class PowTest {

    private Command powCommand;

    @Before
    public void before() {
        powCommand = new Pow();
    }

    @Test
    public void executePowPositiveNumbersTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(2);
        BigDecimal twoNumber = new BigDecimal(3);
        BigDecimal expectedResult = new BigDecimal(8);
        assertEquals(expectedResult, powCommand.execute(oneNumber, twoNumber));
    }

    @Test
    public void executePowNegativeNumberTest() throws Exception {
        BigDecimal oneNumber = new BigDecimal(8);
        BigDecimal twoNumber = new BigDecimal(-1);
        BigDecimal expectedResult = new BigDecimal(0.125);
        assertEquals(expectedResult, powCommand.execute(oneNumber, twoNumber));
    }
}