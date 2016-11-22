package com.aleks.server.service;

import com.aleks.server.Operator;
import com.aleks.server.command.Command;
import com.aleks.server.command.CommandContainer;
import com.aleks.server.validator.CalculateValidator;
import com.aleks.server.validator.Validator;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
@WebService(endpointInterface = "com.aleks.server.service.CalculatorWebService")
public class CalculatorWebServiceImpl implements CalculatorWebService {

    private static final char OPENING_BRACE = '(';
    private static final char CLOSING_BRACE = ')';
    private static final String ERROR_SEQUENCE = "Statement does not valid";

    @Override
    public BigDecimal process(String mathSequence) {
        Validator validator = new CalculateValidator();
        if (!validator.isValid(mathSequence, Validator.STATEMENT_REGEX) || !validator.isCorrectBrackets(mathSequence)) {
            throw new NumberFormatException(ERROR_SEQUENCE);
        }
        LinkedList<BigDecimal> listNumbers = new LinkedList<>();
        LinkedList<Character> listOperations = new LinkedList<>();
        for (int i = 0; i < mathSequence.length(); i++) {
            char currentChar = mathSequence.charAt(i);
            if (currentChar == OPENING_BRACE) {
                listOperations.add(currentChar);
            } else if (currentChar == CLOSING_BRACE) {
                selectionOperation(listNumbers, listOperations.removeLast());
                listOperations.removeLast();
            } else if (validator.isValid(String.valueOf(currentChar), Validator.OPERATOR_REGEX)) {
                saveOperator(listOperations, listNumbers, currentChar);
            } else if (validator.isValid(String.valueOf(currentChar), Validator.NUMBER_REGEX)) {
                i = i + saveNumber(listNumbers, mathSequence.substring(i));
            }
        }
        while (!listOperations.isEmpty()) {
            selectionOperation(listNumbers, listOperations.removeLast());
        }
        return listNumbers.get(0);
    }

    private int saveNumber(LinkedList<BigDecimal> listNumbers, String subString) {
        int res = -1;
        StringBuilder operand = new StringBuilder();
        for (int i = 0; i < subString.length() && Character.isDigit(subString.charAt(i)); i++) {
            operand.append(subString.charAt(i));
            res = res + 1;
        }
        listNumbers.add(new BigDecimal(operand.toString()));
        return res;
    }

    private void saveOperator(LinkedList<Character> listOperations, LinkedList<BigDecimal> listNumbers, char currentChar) {
        if (listNumbers.isEmpty() && Operator.getByOperatorChar(currentChar) != Operator.MINUS) {
            throw new NumberFormatException("statement does not valid");
        }
        while (!listOperations.isEmpty() && listOperations.getLast() != OPENING_BRACE &&
                Operator.getPriorityByChar(listOperations.getLast()) >= Operator.getPriorityByChar(currentChar)) {
            selectionOperation(listNumbers, listOperations.removeLast());
        }
        listOperations.add(currentChar);
    }

    private void selectionOperation(LinkedList<BigDecimal> listNumbers, char operator) {
        BigDecimal firstNumber;
        BigDecimal secondNumber;
        if (listNumbers.size() == 1) {
            secondNumber = BigDecimal.ZERO;
            firstNumber = listNumbers.removeLast();
        } else {
            secondNumber = listNumbers.removeLast();
            firstNumber = listNumbers.removeLast();
        }
        Operator curOperator = Operator.getByOperatorChar(operator);
        Command command = CommandContainer.getCommands().get(curOperator);
        listNumbers.add(command.execute(firstNumber, secondNumber));
    }

}
