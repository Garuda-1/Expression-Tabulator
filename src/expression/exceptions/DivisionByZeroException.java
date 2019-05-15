/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class DivisionByZeroException extends EvaluationException {
    public DivisionByZeroException() {
        super("Division by zero detected");
    }
}
