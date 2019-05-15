package expression.ops;

import expression.exceptions.*;

public class UncheckedIntegerOps implements Ops<Integer> {
    public Integer negate(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -x;
    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) throws EvaluationException {
        if (b == 0) {
            throw (new DivisionByZeroException());
        }
        return a / b;
    }

    public Integer abs(Integer a) {
        if (a >= 0) {
            return a;
        }
        return -a;
    }

    public Integer square(Integer a) {
        return a * a;
    }

    public Integer mod(Integer a, Integer b) throws EvaluationException {
        if (b == 0) {
            throw new NonPositiveModException();
        }
        return a % b;
    }

    public Integer max(Integer a, Integer b) {
        return Integer.max(a, b);
    }

    public Integer min(Integer a, Integer b) {
        return Integer.min(a, b);
    }

    public Integer zero() {
        return 0;
    }

    public Integer parseString(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }

    public Integer parseInteger(int x) throws NumberFormatException {
        return x;
    }

    public boolean containsSymbol(char c) {
        return Character.isDigit(c) || c == '-';
    }
}
