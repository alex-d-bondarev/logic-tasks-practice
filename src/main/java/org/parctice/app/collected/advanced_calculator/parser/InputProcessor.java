package org.parctice.app.collected.advanced_calculator.parser;

import org.parctice.app.hackerrank.java.data_structures.JavaStackBracketsBalancer;

public class InputProcessor {

    public static boolean hasNoExtraSymbols(String expression){
        return expression.matches("[\\(\\)\\+\\-\\*\\/\\d]+");
    }

    public static boolean isParenthesesBalanced(String expression){
        return JavaStackBracketsBalancer.bracketsAreBalanced(expression.replaceAll("[^\\(\\)]", ""));
    }

    public static String replaceBracketsWithParenthesis(String expression) {
        return expression.
                replaceAll("[\\{\\[]", "(").
                replaceAll("[\\]\\}]", ")");
    }

    public static String removeExtraSpaces(String expression) {
        return expression.replaceAll(" ", "");
    }
}
