package org.parctice.app.collected.advanced_calculator.expression;

public abstract class EvaluatingExpression implements Expression {
    protected final Expression left;
    protected final Expression right;

    public EvaluatingExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }
}
