package org.parctice.app.collected.advanced_calculator;

import org.parctice.app.collected.advanced_calculator.parser.ExpressionParser;
import org.parctice.app.collected.advanced_calculator.parser.InputProcessor;
import org.parctice.app.collected.advanced_calculator.parser.ProcessorException;
import org.parctice.app.collected.advanced_calculator.util.ParenthesisUtil;

import static org.parctice.app.collected.advanced_calculator.parser.InputProcessor.removeExtraSpaces;
import static org.parctice.app.collected.advanced_calculator.parser.InputProcessor.replaceBracketsWithParenthesis;

public class AdvancedCalculator {

    public double calculate(String expression) throws ProcessorException {
        expression = replaceBracketsWithParenthesis(removeExtraSpaces(expression));

        if(!InputProcessor.isParenthesesBalanced(expression)){
            throw new ProcessorException("Processed expression '" + expression + "' has unbalanced brackets");
        } else if (!InputProcessor.hasNoExtraSymbols(expression)) {
            throw new ProcessorException("Processed expression '" + expression + "' contains unexpected symbols");
        }

        expression = ParenthesisUtil.addMissedParenthesis(expression);

        return ExpressionParser.parseExpression(expression).evaluate();
    }
}
