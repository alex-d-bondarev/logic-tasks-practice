package org.parctice.app.collected.advanced_calculator.util;

import org.parctice.app.collected.advanced_calculator.model.CharStackParenthesisModel;

import java.util.Stack;

public class ParenthesisUtil {

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
        CharStackParenthesisModel cModel =
                CharStackParenthesisModel.Builder.aModel().
                        withOpeningParenthesis(')').
                        withClosingParenthesis('(').
                        build();

        String reversed = new StringBuilder(expression).reverse().toString();

        return expressionNeedsParenthesisPerModel(reversed, cModel);
    }

    private static boolean needsRightParenthesis(String expression) {
        CharStackParenthesisModel cModel =
                CharStackParenthesisModel.Builder.aModel().
                        withOpeningParenthesis('(').
                        withClosingParenthesis(')').
                        build();

        return expressionNeedsParenthesisPerModel(expression, cModel);
    }

    private static boolean expressionNeedsParenthesisPerModel(
            String expression,
            CharStackParenthesisModel parenthesisModel) {
        Stack<Character> charStack = new Stack<>();
        char nextChar;

        for (int i = 0; i < expression.length(); i++) {
            nextChar = expression.charAt(i);

            if (nextChar == parenthesisModel.getOpeningParenthesis()) {
                charStack.push(nextChar);
            } else if (!charStack.isEmpty() && nextChar == parenthesisModel.getClosingParenthesis()) {
                charStack.pop();
            } else if (nextChar == parenthesisModel.getClosingParenthesis()) {
                return false;
            } else if (!Character.isDigit(nextChar)) {
                return true;
            }
        }
        return true;
    }

//    private static int positionToAddParenthesisAround(String expression) {
//        int nowhere = -1;
//
//        String priorityExpressions = "*/";
//        for (int i = 0; i < expression.length(); i++) {
//            if (priorityExpressions.indexOf(expression.charAt(i)) >= 0 &&
//                    needsLeftParenthesis(expression.substring(0, i)) &&
//                    needsRightParenthesis(expression.substring(i, expression.length() - 1))) {
//                return i;
//            }
//        }
//        return nowhere;
//    }
//
//    public static String addMissedParenthesis(String expression) {
//        while (needsParenthesis(expression)) {
//            expression = addParenthesisAround(expression, positionToAddParenthesisAround(expression));
//        }
//        return expression;
//    }
//
//    private static String addParenthesisAround(String expression, int position) {
//        return addLeftParenthesis(expression.substring(0, position)) +
//                addRightParenthesis(expression.substring(position, expression.length() - 1);
//    }
//
//    private static String addLeftParenthesis(String substring) {
//
//
//    }
//
//    private static String addRightParenthesis(String substring) {
//
//
//    }
}
