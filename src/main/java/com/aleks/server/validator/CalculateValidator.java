package com.aleks.server.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class CalculateValidator implements Validator {

    @Override
    public boolean isValid(String mathSequence, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mathSequence);
        return matcher.find();
    }

    @Override
    public boolean isCorrectBrackets(String mathSequence) {
        int count = 0;
        for (char i : mathSequence.toCharArray()) {
            if (i == '(') {
                count++;
            }
            if (i == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
