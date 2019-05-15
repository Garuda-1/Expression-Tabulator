/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

import expression.ops.Ops;

public class Variable<T> implements UnifiedExpression<T> {
    private String name;
    private Ops<T> ops;

    public Variable(String name, Ops<T> ops) {
        this.name = name;
        this.ops = ops;
    }

    public T evaluate(T x, T y, T z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                return ops.zero();
        }
    }
}
