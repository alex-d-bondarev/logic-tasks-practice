package org.parctice.app.collected.advanced_calculator.tests;

import org.junit.Assert;
import org.junit.Test;
import org.parctice.app.collected.advanced_calculator.parser.ExpressionParser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
