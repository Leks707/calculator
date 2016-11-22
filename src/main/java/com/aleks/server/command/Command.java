package com.aleks.server.command;

import java.math.BigDecimal;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public interface Command {

    /**
     * This method execute mathematical operation between firstNumber and secondNumber
     *
     * @param firstNumber  for mathematics operation
     * @param secondNumber for mathematics operation
     * @return result in BigDecimal of concrete mathematical operation
     */
    BigDecimal execute(BigDecimal firstNumber, BigDecimal secondNumber);
}
