/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class OverflowException extends EvaluationException {
    public OverflowException() {
        super("Integer data type overflow detected");
    }
}
