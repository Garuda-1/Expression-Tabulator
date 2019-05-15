/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public class Add<T> extends AbstractBinaryOperation<T> {
    public Add(UnifiedExpression<T> leftExpression, UnifiedExpression<T> rightExpression, Ops<T> ops) {
        super(leftExpression, rightExpression, ops);
    }

    protected T apply(T a, T b) throws EvaluationException {
        return ops.add(a, b);
    }
}
