/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class MissingOperandException extends ParserException {
    public MissingOperandException(String source, int pos) {
        super("Missing operand around " + pos + System.lineSeparator() + show(source, pos));
    }
}
