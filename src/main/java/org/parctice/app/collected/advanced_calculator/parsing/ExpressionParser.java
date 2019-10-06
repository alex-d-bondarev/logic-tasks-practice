package org.parctice.app.collected.advanced_calculator.parsing;

/*
* Credit for idea: https://www2.seas.gwu.edu/~simhaweb/cs1112/modules/module10/suppl/index.html
* */
public class ExpressionParser {

    public static String replaceBracketsWithParenthesis(String expression){
        return expression.
                replaceAll("[\\{\\[]", "(").
                replaceAll("[\\]\\}]", ")");
    }
}
