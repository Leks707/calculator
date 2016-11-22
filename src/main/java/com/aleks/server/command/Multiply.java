package com.aleks.server.command;

import java.math.BigDecimal;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class Multiply implements Command {

    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.multiply(secondNumber);
    }
}
