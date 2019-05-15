/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public abstract class AbstractUnaryOperation<T> implements UnifiedExpression<T> {
    private UnifiedExpression<T> expression;
    protected Ops<T> ops;

    AbstractUnaryOperation(UnifiedExpression<T> expression, Ops<T> ops) {
        this.expression = expression;
        this.ops = ops;
    }

    public T evaluate(T x, T y, T z) throws EvaluationException {
        return apply(expression.evaluate(x, y, z));
    }

    protected abstract T apply(T a) throws EvaluationException;
}
