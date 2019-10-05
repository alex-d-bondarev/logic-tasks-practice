package org.parctice.app.collected.advanced_calculator.expression;

public class DifferenceExpression extends EvaluatingExpression {
    public DifferenceExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
