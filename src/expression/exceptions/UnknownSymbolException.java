/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class UnknownSymbolException extends ParserException {
    public UnknownSymbolException(String source, int pos) {
        super("Unable to resolve symbol at position " + pos + System.lineSeparator() + show(source, pos));
    }
}
