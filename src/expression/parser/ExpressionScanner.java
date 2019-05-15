/*
 * Copyright (c) 2019. ITMO Homework by Ian Dolzhansky
 */

package expression.parser;

import expression.exceptions.*;
import expression.ops.Ops;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpressionScanner<T> {
    private String src;
    private int i;
    private int balance;
    private T val;
    private Ops<T> ops;
    private String varName;
    private Token token;
    private Set<Token> operations = EnumSet.of(Token.NEGATE, Token.ABS, Token.SQUARE, Token.MOD, Token.PLUS, Token.MINUS, Token.MUL, Token.DIV);
    private Map<String, Token> stringTokenMap;

    public ExpressionScanner(String s, Ops<T> ops) {
        src = s;
        i = 0;
        token = Token.START;
        this.ops = ops;
        stringTokenMap = new HashMap<>();
        stringTokenMap.put("x", Token.VARIABLE);
        stringTokenMap.put("y", Token.VARIABLE);
        stringTokenMap.put("z", Token.VARIABLE);
        stringTokenMap.put("abs", Token.ABS);
        stringTokenMap.put("square", Token.SQUARE);
        stringTokenMap.put("mod", Token.MOD);
    }

    private void testOperandExpected() throws MissingOperandException {
        if (operations.contains(token) || token == Token.BRACKET_OPEN || token == Token.START) {
            throw new MissingOperandException(src, i);
        }
    }

    private void testOperationExpected() throws MissingOperationException {
        if (token == Token.NUMBER || token == Token.VARIABLE || token == Token.BRACKET_CLOSE) {
            throw new MissingOperationException(src, i);
        }
    }

    private void skipForward() {
        while (i < src.length() && Character.isWhitespace(src.charAt(i))) {
            i++;
        }
    }

    private String extractNumber(int i) {
        int l = i;
        while (i < src.length() && ops.containsSymbol(src.charAt(i))) {
            i++;
        }
        return src.substring(l, i);
    }

    private boolean isOperationSymbol(char c) {
        return Character.isLetterOrDigit(c);
    }

    private String extractOperation() {
        int l = i;
        while (i < src.length() && isOperationSymbol(src.charAt(i))) {
            i++;
        }
        return src.substring(l, i--);
    }

    public Token getToken() {
        return token;
    }

    Token getNextToken() throws ParserException {
        nextToken();
        return token;
    }

    T getVal() {
        return val;
    }

    String getVarName() {
        return varName;
    }

    int getPos() {
        return i;
    }

    String getSrc() {
        return src;
    }

    public void nextToken() throws ParserException {
        skipForward();
        if (i == src.length()) {
            testOperandExpected();
            token = Token.END;
            return;
        }
        switch (src.charAt(i)) {
            case '-': {
                if (token == Token.NUMBER || token == Token.VARIABLE || token == Token.BRACKET_CLOSE) {
                    token = Token.MINUS;
                    break;
                } else {
                    i++;
                    skipForward();
                    if (i == src.length()) {
                        throw new MissingOperandException(src, i);
                    } else {
                        String number = extractNumber(i);
                        if (number.length() == 0) {
                            token = Token.NEGATE;
                            i--;
                            break;
                        }
                        try {
                            val = ops.parseString('-' + number);
                        } catch (NumberFormatException e) {
                            throw new ConstantOverflowException(src, i, i + number.length() - 1);
                        }
                        i += number.length() - 1;
                        token = Token.NUMBER;
                        break;
                    }
                }
            }
            case '+': {
                testOperandExpected();
                token = Token.PLUS;
                break;
            }
            case '*': {
                testOperandExpected();
                token = Token.MUL;
                break;
            }
            case '/': {
                testOperandExpected();
                token = Token.DIV;
                break;
            }
            case '(': {
                testOperationExpected();
                balance++;
                token = Token.BRACKET_OPEN;
                break;
            }
            case ')': {
                if (operations.contains(token) || token == Token.BRACKET_OPEN) {
                    throw new MissingOperandException(src, i);
                }
                balance--;
                if (balance < 0) {
                    throw new UnbalancedBracketsException(src, i);
                }
                token = Token.BRACKET_CLOSE;
                break;
            }
            default: {
                if (Character.isDigit(src.charAt(i))) {
                    String number = extractNumber(i);
                    try {
                        val = ops.parseString(number);
                    } catch (NumberFormatException e) {
                        throw new ConstantOverflowException(src, i, i + number.length() - 1);
                    }
                    i += number.length() - 1;
                    token = Token.NUMBER;
                } else {
                    String operation = extractOperation();
                    if (!stringTokenMap.containsKey(operation)) {
                        throw new UnknownSymbolException(src, i);
                    }
                    token = stringTokenMap.get(operation);
                    if (token == Token.VARIABLE) {
                        varName = operation;
                    }
                    break;
                }
            }
        }
        i++;
    }
}
