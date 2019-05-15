/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class NegativeSqrtArgumentException extends EvaluationException {
    public NegativeSqrtArgumentException() {
        super("Negative value under square root function detected");
    }
}
