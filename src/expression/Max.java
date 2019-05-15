/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.ops.Ops;

public class Max<T> extends AbstractBinaryOperation<T> {
    public Max(UnifiedExpression<T> leftExpression, UnifiedExpression<T> rightExpression, Ops<T> ops) {
        super(leftExpression, rightExpression, ops);
    }

    protected T apply(T a, T b) {
        return ops.max(a, b);
    }
}
