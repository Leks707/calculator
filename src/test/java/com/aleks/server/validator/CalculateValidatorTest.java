package com.aleks.server.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class CalculateValidatorTest {

    private Validator validator;

    @Before
    public void before() {
        validator = new CalculateValidator();
    }

    @Test
    public void validMathSequenceTest() {
        String mathSequence = "1-(2/4+7*1)-2^2";
        assertTrue(validator.isValid(mathSequence, Validator.STATEMENT_REGEX));
    }

    @Test
    public void notValidMathSequenceTest() {
        String mathSequence = "not1-(2/4+7*1)-2^2";
        assertFalse(validator.isValid(mathSequence, Validator.STATEMENT_REGEX));
    }

    @Test
    public void correctBracketsTest() throws Exception {
        String mathSequence = "(1-(2/4+7*1)-(2^2))";
        assertTrue(validator.isCorrectBrackets(mathSequence));
    }

    @Test
    public void notCorrectBracketsTest() throws Exception {
        String mathSequence = ")(1-(2/4+7*1)-(2^2))(";
        assertFalse(validator.isCorrectBrackets(mathSequence));
    }

}