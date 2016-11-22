package com.aleks.server;

/**
 * Created by Oleksii_Shylo on 11/22/2016.
 */
public enum Operator {

    PLUS('+', 1), MINUS('-', 1), MULTIPLY('*', 2), DIVISION('/', 2), POW('^', 3);

    char operatorChar;
    int priority;

    Operator(char operatorChar, int priority) {
        this.operatorChar = operatorChar;
        this.priority = priority;
    }

    public static Operator getByOperatorChar(char operatorChar) {
        for (Operator operator : values()) {
            if (operator.operatorChar == operatorChar) {
                return operator;
            }
        }
        return null;
    }

    public static int getPriorityByChar(char operatorChar) {
        return getByOperatorChar(operatorChar).priority;
    }
}
