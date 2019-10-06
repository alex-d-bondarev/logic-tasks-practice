package org.parctice.app.collected.advanced_calculator.validator;

import java.util.Stack;

public class ExpressionValidator {

    public static boolean needsParenthesis(String expression) {
        boolean needsParenthesis = false;
        String priorityExpressions = "*/";
        for (int i = 0; i < expression.length(); i++) {
            if (priorityExpressions.indexOf(expression.charAt(i)) >= 0 &&
                    needsLeftParenthesis(expression.substring(0, i)) &&
                    needsRightParenthesis(expression.substring(i, expression.length() - 1))) {
                needsParenthesis = true;
            }
        }
        return needsParenthesis;
    }

    private static boolean needsLeftParenthesis(String expression) {
        Stack<Character> charStack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char nextChar = expression.charAt(i);

            if (nextChar == ')') {
                charStack.push(nextChar);
            } else if (!charStack.isEmpty() && nextChar == '(') {
                charStack.pop();
            } else if (nextChar == '(') {
                return false;
            } else if (!Character.isDigit(nextChar)) {
                return true;
            }
        }

        return true;
    }

    private static boolean needsRightParenthesis(String expression) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char nextChar = expression.charAt(i);

            if (nextChar == '(') {
                charStack.push(nextChar);
            } else if (!charStack.isEmpty() && nextChar == ')') {
                charStack.pop();
            } else if (nextChar == ')') {
                return false;
            } else if (!Character.isDigit(nextChar)) {
                return true;
            }
        }
        return true;
    }
}
