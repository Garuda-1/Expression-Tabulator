/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class EmptySourceException extends ParserException {
    public EmptySourceException() {
        super("Nothing to parse");
    }
}
