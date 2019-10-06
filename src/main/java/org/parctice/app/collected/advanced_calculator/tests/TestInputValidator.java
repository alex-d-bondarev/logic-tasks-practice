package org.parctice.app.collected.advanced_calculator.tests;

import org.junit.Test;
import org.parctice.app.collected.advanced_calculator.validator.InputValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestInputValidator {

    @Test
    public void testValidBracketsWithoutAdditionalChars(){
        String testInput = "(())";
        assertTrue(InputValidator.isParenthesesBalanced(testInput));
    }

    @Test
    public void testInvalidBracketsWithoutAdditionalChars(){
        String testInput = "(())(";
        assertFalse(InputValidator.isParenthesesBalanced(testInput));
    }

    @Test
    public void testValidBracketsWithAdditionalChars(){
        String testInput = "(({{[abc_123+_*&]}}))";
        assertTrue(InputValidator.isParenthesesBalanced(testInput));
    }

    @Test
    public void testExpressionWithValidChars(){
        String testInput = "1+2*(4-3/5)";
        assertTrue(InputValidator.hasNoExtraSymbols(testInput));
    }

    @Test
    public void testExpressionWithInvalidChars(){
        String testInput = "abc&^%$1+2*(4-3/5)";
        assertFalse(InputValidator.hasNoExtraSymbols(testInput));
    }

    @Test
    public void simpleExpressionIsValid(){
        String testInput = "1+2";
        assertTrue(InputValidator.isValid(testInput));
    }

    @Test
    public void complexExpressionIsValid(){
        String testInput = "1+2-(3*(5/(6+7)))";
        assertTrue(InputValidator.isValid(testInput));
    }

    @Test
    public void onlyParenthesisAllowed(){
        String testInput = "[1+2]-(3*(5/{6+7}))";
        assertFalse(InputValidator.isValid(testInput));
    }
}
