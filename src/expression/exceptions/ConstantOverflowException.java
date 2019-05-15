/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class ConstantOverflowException extends ParserException {
    public ConstantOverflowException(String source, int startPos, int endPos) {
        super("Too long constant at " + startPos + System.lineSeparator() + show(source, startPos, endPos));
    }
}
