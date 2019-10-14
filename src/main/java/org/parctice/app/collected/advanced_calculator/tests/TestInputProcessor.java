package org.parctice.app.collected.advanced_calculator.tests;

import org.junit.Test;
import org.parctice.app.collected.advanced_calculator.processor.InputProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestInputProcessor {

    @Test
    public void testValidBracketsWithoutAdditionalChars(){
        String testInput = "(())";
        assertTrue(InputProcessor.isParenthesesBalanced(testInput));
    }

    @Test
    public void testInvalidBracketsWithoutAdditionalChars(){
        String testInput = "(())(";
        assertFalse(InputProcessor.isParenthesesBalanced(testInput));
    }

    @Test
    public void testValidBracketsWithAdditionalChars(){
        String testInput = "(({{[abc_123+_*&]}}))";
        assertTrue(InputProcessor.isParenthesesBalanced(testInput));
    }

    @Test
    public void testExpressionWithValidChars(){
        String testInput = "1+2*(4-3/5)";
        assertTrue(InputProcessor.hasNoExtraSymbols(testInput));
    }

    @Test
    public void testExpressionWithInvalidChars(){
        String testInput = "abc&^%$1+2*(4-3/5)";
        assertFalse(InputProcessor.hasNoExtraSymbols(testInput));
    }

    @Test
    public void allBracketsAreParenthesis(){
        String testExpression = "{[()]}";
        String expectedExpression = "((()))";

        assertEquals(
                expectedExpression,
                InputProcessor.replaceBracketsWithParenthesis(testExpression));
    }

    @Test
    public void allExtraSpacesRemoved(){
        String testExpression = " 2 + 2* 2";
        String expectedExpression = "2+2*2";

        assertEquals(
                expectedExpression,
                InputProcessor.removeExtraSpaces(testExpression));
    }
}
