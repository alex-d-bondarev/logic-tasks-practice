package org.parctice.app.collected.advanced_calculator.tests;

import org.junit.Test;
import org.parctice.app.collected.advanced_calculator.util.ParenthesisUtil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestParenthesisUtil {

    @Test
    public void sumDoesNotNeedParenthesis(){
        String testExpression = "2+2+2";
        assertFalse(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void differenceDoesNotNeedParenthesis(){
        String testExpression = "2-2-2";
        assertFalse(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void simpleMultiplicationNeedsParenthesis(){
        String testExpression = "2*2";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void simpleDivisionNeedsParenthesis(){
        String testExpression = "2/2";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void longExpressionWithPriorityNeedsParenthesis(){
        String testExpression = "2*2+2*2+2/2";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void longExpressionWithPriorityAlreadyHasParenthesis(){
        String testExpression = "(2*2)+(2*2)+(2/2)";
        assertFalse(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void longExpressionLostSomeParenthesisInTheEnd(){
        String testExpression = "(2*2)+(2*2)+2/2";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void longExpressionLostSomeParenthesisInTheBeginning(){
        String testExpression = "(2*2)+2*2+(2/2)";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void longExpressionLostSomeParenthesisInTheMiddle(){
        String testExpression = "(2*2)+2*2+(2/2)";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void complexExpressionNeedsParenthesis(){
        String testExpression = "(2+2*(2/2))";
        assertTrue(ParenthesisUtil.needsParenthesis(testExpression));
    }

    @Test
    public void complexExpressionDoesNotNeedParenthesis(){
        String testExpression = "(2+(2*(2/2)))";
        assertFalse(ParenthesisUtil.needsParenthesis(testExpression));
    }
}
