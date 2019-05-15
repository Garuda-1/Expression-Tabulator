/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression;

public class Const<T> implements UnifiedExpression<T> {
    private T value;

    public Const(T value) {
        this.value = value;
    }

    public T evaluate(T x, T y, T z) {
        return value;
    }
}
