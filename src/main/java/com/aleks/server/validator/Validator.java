package com.aleks.server.validator;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public interface Validator {

    String OPERATOR_REGEX = "\\+|\\-|\\*|\\/|\\^";
    String STATEMENT_REGEX = "^(\\d|\\+|\\-|\\*|\\/|\\^|\\(|\\)){2,}";
    String NUMBER_REGEX = "\\d";

    /**
     * This method checks that mathSequence is correct and contains only mathematics chars.
     *
     * @param mathSequence string mathematical statement that must be checked
     * @param regex        regular expression which is checking string mathSequence
     * @return boolean value. Return true if mathSequence has correct mathematics chars.
     */
    boolean isValid(String mathSequence, String regex);

    /**
     * This method checks that mathSequence has correct count of brackets.
     *
     * @param mathSequence string mathematical statement that must be checked
     * @return boolean value. Return true if mathSequence has correct count of brackets.
     */
    boolean isCorrectBrackets(String mathSequence);
}
