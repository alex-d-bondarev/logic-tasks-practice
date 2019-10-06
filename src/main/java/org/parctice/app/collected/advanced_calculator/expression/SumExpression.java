package org.parctice.app.collected.advanced_calculator.expression;

public class SumExpression extends EvaluatingExpression {

    public SumExpression(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}