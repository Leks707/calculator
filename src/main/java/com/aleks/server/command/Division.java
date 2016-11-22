package com.aleks.server.command;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public class Division implements Command {

    @Override
    public BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.divide(secondNumber, 3, RoundingMode.HALF_EVEN);
    }
}
