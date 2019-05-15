/*
 * Copyright (c) 2018. ITMO Homework by Ian Dolzhansky
 */

package expression.exceptions;

public class ParserException extends Exception {
    public ParserException(String message) {
        super(message);
    }

    static String show(String source, int pos) {
        StringBuilder ret = new StringBuilder();
        ret.append(source);
        ret.append(System.lineSeparator());
        for (int i = 0; i < pos; i++) {
            ret.append(' ');
        }
        ret.append('^');
        return ret.toString();
    }

    static String show(String source, int startPos, int endPos) {
        StringBuilder ret = new StringBuilder();
        ret.append(source);
        ret.append(System.lineSeparator());
        for (int i = 0; i < startPos; i++) {
            ret.append(' ');
        }
        ret.append('^');
        for (int i = startPos + 1; i < endPos; i++) {
            ret.append('~');
        }
        ret.append('^');
        return ret.toString();
    }
}
