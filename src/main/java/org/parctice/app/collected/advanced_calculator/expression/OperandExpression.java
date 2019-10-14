package org.parctice.app.collected.advanced_calculator.expression;

public abstract class OperandExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public OperandExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
}
