/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.exceptions.EvaluationException;
import expression.ops.Ops;

public class Square<T> extends AbstractUnaryOperation<T> {
    public Square(UnifiedExpression<T> expression, Ops<T> ops) {
        super(expression, ops);
    }

    protected T apply(T a) throws EvaluationException {
        return ops.square(a);
    }
}
