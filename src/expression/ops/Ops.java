package expression.ops;

import expression.exceptions.EvaluationException;
import expression.exceptions.ParserException;

public interface Ops<T> {
    T negate(T a) throws EvaluationException;

    T add(T a, T b) throws  EvaluationException;

    T subtract(T a, T b) throws EvaluationException;

    T multiply(T a, T b) throws EvaluationException;

    T divide(T a, T b) throws EvaluationException;

    T abs(T a) throws EvaluationException;

    T square(T a) throws EvaluationException;

    T mod(T a, T b) throws EvaluationException;

    T max(T a, T b);

    T min(T a, T b);

    T zero();

    T parseString(String number) throws NumberFormatException;

    T parseInteger(int x) throws NumberFormatException;

    boolean containsSymbol(char c);
}
