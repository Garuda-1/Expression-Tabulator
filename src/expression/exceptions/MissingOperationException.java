/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class MissingOperationException extends ParserException {
    public MissingOperationException(String source, int pos) {
        super("Missing operand at " + pos + System.lineSeparator() + show(source, pos));
    }
}
