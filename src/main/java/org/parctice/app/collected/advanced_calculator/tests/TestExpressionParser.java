package org.parctice.app.collected.advanced_calculator.tests;

import org.junit.Assert;
import org.junit.Test;
import org.parctice.app.collected.advanced_calculator.expression.Expression;
import org.parctice.app.collected.advanced_calculator.parsing.ExpressionParser;

public class TestExpressionParser {

    @Test
    public void allBracketsAreParenthesis(){
        String testExpression = "{[()]}";
        String expectedExpression = "((()))";

        Assert.assertEquals(
                expectedExpression,
                ExpressionParser.replaceBracketsWithParenthesis(testExpression));
    }
}
