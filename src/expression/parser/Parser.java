/*
 * Copyright (c) 2019. ITMO Homework by Ian Dolzhansky
 */

package expression.parser;

import expression.TripleExpression;
import expression.exceptions.ParserException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParserException;
}
