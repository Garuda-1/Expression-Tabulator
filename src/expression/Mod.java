/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public class Mod<T> extends AbstractBinaryOperation<T> {
    public Mod(UnifiedExpression<T> leftExpression, UnifiedExpression<T> rightExpression, Ops<T> ops) {
        super(leftExpression, rightExpression, ops);
    }

    protected T apply(T a, T b) throws EvaluationException {
        return ops.mod(a, b);
    }
}
