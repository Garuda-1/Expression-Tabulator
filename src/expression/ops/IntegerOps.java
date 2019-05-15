package expression.ops;

import expression.exceptions.*;

public class IntegerOps implements Ops<Integer> {
    public Integer negate(Integer x) throws OverflowException {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -x;
    }

    public Integer add(Integer a, Integer b) throws OverflowException {
        if (b > 0) {
            if (a > Integer.MAX_VALUE - b) {
                throw new OverflowException();
            }
        } else {
            if (a < Integer.MIN_VALUE - b) {
                throw new OverflowException();
            }
        }
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) throws OverflowException {
        if (b > 0) {
            if (a < Integer.MIN_VALUE + b) {
                throw (new OverflowException());
            }
        } else {
            if (a > Integer.MAX_VALUE + b) {
                throw (new OverflowException());
            }
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) throws EvaluationException {
        int limit = Integer.signum(a) == Integer.signum(b) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (a != 0 &&
                (b > 0 && b > ((a == -1 && limit == Integer.MIN_VALUE) ? Integer.MAX_VALUE : limit / a) ||
                        b < 0 && b < ((a == -1 && limit == Integer.MIN_VALUE) ? Integer.MAX_VALUE : limit / a))) {
            throw (new OverflowException());
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) throws EvaluationException {
        if (b == 0) {
            throw (new DivisionByZeroException());
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw (new OverflowException());
        }
        return a / b;
    }

    public Integer abs(Integer a) throws EvaluationException {
        if (a >= 0) {
            return a;
        }
        if (a == Integer.MIN_VALUE) {
            throw (new OverflowException());
        }
        return -a;
    }

    public Integer square(Integer a) throws EvaluationException {
        if (a > 46340 || a < -46340) {
            throw new OverflowException();
        }
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
