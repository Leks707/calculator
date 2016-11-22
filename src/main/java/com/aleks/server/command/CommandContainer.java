package com.aleks.server.command;

import com.aleks.server.Operator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
public class CommandContainer {

    private static Map<Operator, Command> commands = new HashMap<>();

    static {
        commands.put(Operator.PLUS, new Plus());
        commands.put(Operator.MINUS, new Minus());
        commands.put(Operator.DIVISION, new Division());
        commands.put(Operator.MULTIPLY, new Multiply());
        commands.put(Operator.POW, new Pow());
    }

    public static Map<Operator, Command> getCommands() {
        return commands;
    }
}
