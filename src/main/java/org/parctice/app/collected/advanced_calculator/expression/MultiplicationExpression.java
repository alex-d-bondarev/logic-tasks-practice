package org.parctice.app.collected.advanced_calculator.expression;

public class MultiplicationExpression extends EvaluatingExpression {
    public MultiplicationExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
