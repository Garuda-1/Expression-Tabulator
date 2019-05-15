/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public abstract class AbstractBinaryOperation<T> implements UnifiedExpression<T> {
    private UnifiedExpression<T> leftExpression;
    private UnifiedExpression<T> rightExpression;
    protected Ops<T> ops;

    AbstractBinaryOperation(UnifiedExpression<T> leftExpression, UnifiedExpression<T> rightExpression, Ops<T> ops) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.ops = ops;
    }
    public T evaluate(T x, T y, T z) throws EvaluationException {
        return apply(leftExpression.evaluate(x, y, z), rightExpression.evaluate(x, y, z));
    }

    protected abstract T apply(T a, T b) throws EvaluationException;
}
