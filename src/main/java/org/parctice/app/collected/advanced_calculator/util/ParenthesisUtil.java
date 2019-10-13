package org.parctice.app.collected.advanced_calculator.util;

import org.parctice.app.collected.advanced_calculator.model.CharStackParenthesisModel;

import java.util.Stack;

public class ParenthesisUtil {

    private static final CharStackParenthesisModel PARENTHESIS_TO_THE_LEFT =
            CharStackParenthesisModel.Builder.aModel().
                    withOpeningParenthesis(')').
                    withClosingParenthesis('(').
                    build();

    private static final CharStackParenthesisModel PARENTHESIS_TO_THE_RIGHT =
            CharStackParenthesisModel.Builder.aModel().
                    withOpeningParenthesis('(').
                    withClosingParenthesis(')').
                    build();

    private static final String PRIORITY_PARENTHESIS = "*/";


    public static String addMissedParenthesis(String expression) {
        while (needsParenthesis(expression)) {
            expression = addParenthesisAround(expression, positionToAddParenthesisAround(expression));
        }
        return expression;
    }

    public static boolean needsParenthesis(String expression) {
        boolean needsParenthesis = false;
        for (int i = 0; i < expression.length(); i++) {
            if (PRIORITY_PARENTHESIS.indexOf(expression.charAt(i)) >= 0 &&
                    needsLeftParenthesis(expression.substring(0, i)) &&
                    needsRightParenthesis(expression.substring(i, expression.length() - 1))) {
                needsParenthesis = true;
            }
        }
        return needsParenthesis;
    }

    private static int positionToAddParenthesisAround(String expression) {
        int nowhere = -1;

        for (int i = 0; i < expression.length(); i++) {
            if (PRIORITY_PARENTHESIS.indexOf(expression.charAt(i)) >= 0 &&
                    needsLeftParenthesis(expression.substring(0, i)) &&
                    needsRightParenthesis(expression.substring(i))) {
                return i;
            }
        }
        return nowhere;
    }

    private static String addParenthesisAround(String expression, int position) {
        String leftPart = expression.substring(0, position);
        char middlePart = expression.charAt(position);
        String rightPart = expression.substring(position + 1);

        leftPart = new StringBuilder(leftPart).reverse().toString();
        leftPart = addParenthesisPerModel(leftPart, PARENTHESIS_TO_THE_LEFT);
        leftPart = new StringBuilder(leftPart).reverse().toString();

        rightPart = addParenthesisPerModel(rightPart, PARENTHESIS_TO_THE_RIGHT);

        return leftPart + middlePart + rightPart;
    }

    private static boolean needsLeftParenthesis(String expression) {
        String reversed = new StringBuilder(expression).reverse().toString();
        return needParenthesisPerModel(reversed, PARENTHESIS_TO_THE_LEFT);
    }

    private static boolean needsRightParenthesis(String expression) {
        return needParenthesisPerModel(expression, PARENTHESIS_TO_THE_RIGHT);
    }

    private static boolean needParenthesisPerModel(String expression, CharStackParenthesisModel parenthesisModel) {
        int positionForParenthesis = getClosingParenthesisPosition(expression, parenthesisModel);
        return positionForParenthesis  >= 0 &&
                expression.charAt(positionForParenthesis) != parenthesisModel.getClosingParenthesis();
    }

    private static String addParenthesisPerModel(String expression, CharStackParenthesisModel parenthesisModel) {
        int positionForParenthesis = getClosingParenthesisPosition(expression, parenthesisModel);

        if(positionForParenthesis < 0){
            return expression + parenthesisModel.getClosingParenthesis();
        } else {
            return expression.substring(0, positionForParenthesis) +
                    parenthesisModel.getClosingParenthesis() +
                    expression.substring(positionForParenthesis);
        }
    }

    /**
     * @param expression       string of expression to search
     * @param parenthesisModel that contains description of expected parenthesises
     * @return the index of closing parenthesis or -1 if none was found
     */
    private static int getClosingParenthesisPosition(String expression, CharStackParenthesisModel parenthesisModel) {
        Stack<Character> charStack = new Stack<>();
        char nextChar;
        int positionNotFound = -1;

        for (int i = 0; i < expression.length(); i++) {
            nextChar = expression.charAt(i);

            if (nextChar == parenthesisModel.getOpeningParenthesis()) {
                charStack.push(nextChar);
            } else if (!charStack.isEmpty() && nextChar == parenthesisModel.getClosingParenthesis()) {
                charStack.pop();
            } else if (charStack.isEmpty() && !Character.isDigit(nextChar)) {
                return i;
            }
        }
        return positionNotFound;
    }
}
