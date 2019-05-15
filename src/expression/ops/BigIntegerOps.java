package expression.ops;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.EvaluationException;
import expression.exceptions.NonPositiveModException;

import java.math.BigInteger;

public class BigIntegerOps implements Ops<BigInteger> {
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    public BigInteger divide(BigInteger a, BigInteger b) throws EvaluationException {
        if (b.compareTo(BigInteger.ZERO) == 0) {
            throw new DivisionByZeroException();
        }
        return a.divide(b);
    }

    public BigInteger abs(BigInteger a){
        return a.abs();
    }

    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    public BigInteger mod(BigInteger a, BigInteger b) throws EvaluationException {
        if (b.compareTo(BigInteger.ZERO) <= 0) {
            throw new NonPositiveModException();
        }
        return a.mod(b);
    }

    public BigInteger max(BigInteger a, BigInteger b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    public BigInteger min(BigInteger a, BigInteger b) {
        if (a.compareTo(b) < 0) {
            return a;
        } else {
            return b;
        }
    }

    public BigInteger zero() {
        return BigInteger.ZERO;
    }

    public BigInteger parseString(String number) throws NumberFormatException {
        return new BigInteger(number);
    }

    public BigInteger parseInteger(int x) throws NumberFormatException {
        return BigInteger.valueOf(x);
    }

    public boolean containsSymbol(char c) {
        return Character.isDigit(c) || c == '-';
    }
}
