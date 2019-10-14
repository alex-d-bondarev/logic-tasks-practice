package org.parctice.app.collected.advanced_calculator.expression;

public class DivisionExpression extends OperandExpression {
    public DivisionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() / right.evaluate();
    }
}
