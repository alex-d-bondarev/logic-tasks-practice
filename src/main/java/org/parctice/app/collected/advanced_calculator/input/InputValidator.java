package org.parctice.app.collected.advanced_calculator.input;

import org.parctice.app.hackerrank.java.data_structures.JavaStack;

public class InputValidator {

    public static boolean hasNoExtraSymbols(String expression){
        return expression.matches("[\\(\\)\\+\\-\\*\\/\\d]+");
    }

    public static boolean isParenthesesBalanced(String expression){
        return JavaStack.bracketsAreBalanced(expression.replaceAll("[^\\(\\)]", ""));
    }

    public static boolean isValid(String expression){
        return hasNoExtraSymbols(expression) && isParenthesesBalanced(expression);
    }
}
