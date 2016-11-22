package com.aleks.server.command;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class Pow implements Command {

    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.pow(secondNumber.intValue(), new MathContext(3));
    }
}
