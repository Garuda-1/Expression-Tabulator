/*
 * Copyright (c) 2019. ITMO Homework by Ian Dolzhansky
 */

package expression.parser;

import expression.*;
import expression.exceptions.ParserException;
import expression.exceptions.UnbalancedBracketsException;
import expression.ops.Ops;

public class ExpressionParser<T> implements Parser<T> {
    private ExpressionScanner<T> scanner;
    private Ops<T> ops;

    public ExpressionParser(Ops<T> ops) {
        this.ops = ops;
    }

    public TripleExpression<T> parse(String s) throws ParserException {
        scanner = new ExpressionScanner<>(s, ops);
        return priority4();
    }

    private UnifiedExpression<T> priority4() throws ParserException {
        UnifiedExpression<T> ret = priority3();
        do {
            switch (scanner.getToken()) {
                case PLUS: {
                    ret = new Add<>(ret, priority3(), ops);
                    break;
                }
                case MINUS: {
                    ret = new Subtract<>(ret, priority3(), ops);
                    break;
                }
                default: {
                    return ret;
                }
            }
        } while (true);
    }

    private UnifiedExpression<T> priority3() throws ParserException {
        UnifiedExpression<T> ret = priority2();
        do {
            switch (scanner.getToken()) {
                case MUL: {
                    ret = new Multiply<>(ret, priority2(), ops);
                    break;
                }
                case DIV: {
                    ret = new Divide<>(ret, priority2(), ops);
                    break;
                }
                default: {
                    return ret;
                }
            }
        } while (true);
    }

    private UnifiedExpression<T> priority2() throws ParserException {
        UnifiedExpression<T> ret = priority1();
        do {
            if (scanner.getToken() == Token.MOD) {
                ret = new Mod<>(ret, priority1(), ops);
            } else {
                return ret;
            }
        } while (true);
    }

    private UnifiedExpression<T> priority1() throws ParserException {
        UnifiedExpression<T> ret;
        switch (scanner.getNextToken()) {
            case NUMBER: {
                ret = new Const<>(scanner.getVal());
                scanner.nextToken();
                break;
            }
            case VARIABLE: {
                ret = new Variable<>(scanner.getVarName(), ops);
                scanner.nextToken();
                break;
            }
            case NEGATE: {
                ret = new Negate<>(priority1(), ops);
                break;
            }
            case ABS: {
                ret = new Abs<>(priority1(), ops);
                break;
            }
            case SQUARE: {
                ret = new Square<>(priority1(), ops);
                break;
            }
            case BRACKET_OPEN: {
                int pos = scanner.getPos();
                ret = priority4();
                if (scanner.getToken() != Token.BRACKET_CLOSE) {
                    throw new UnbalancedBracketsException(scanner.getSrc(), pos - 1);
                }
                scanner.getNextToken();
                break;
            }
            default: {
                throw new ParserException("Invalid expression");
            }
        }
        return ret;
    }
}
