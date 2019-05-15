/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public class Abs<T> extends AbstractUnaryOperation<T> {
    public Abs(UnifiedExpression<T> expression, Ops<T> ops) {
        super(expression, ops);
    }

    protected T apply(T a) throws EvaluationException {
        return ops.abs(a);
    }
}
