/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class UnbalancedBracketsException extends ParserException {
    public UnbalancedBracketsException(String source, int pos) {
        super("Unbalanced brackets detected at " + pos
                + System.lineSeparator() + show(source, pos));
    }
}
