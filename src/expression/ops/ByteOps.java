package expression.ops;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.EvaluationException;
import expression.exceptions.NonPositiveModException;

public class ByteOps implements Ops<Byte> {
    public Byte negate(Byte a) {
        return (byte) -a;
    }

    public Byte add(Byte a, Byte b) {
        return (byte) (a + b);
    }

    public Byte subtract(Byte a, Byte b) {
        return (byte) (a - b);
    }

    public Byte multiply(Byte a, Byte b) {
        return (byte) (a * b);
    }

    public Byte divide(Byte a, Byte b) throws EvaluationException {
        if (b == 0) {
            throw (new DivisionByZeroException());
        }
        return (byte) (a / b);
    }

    public Byte abs(Byte a) {
        if (a < 0) {
            return (byte) -a;
        }
        return a;
    }

    public Byte square(Byte a) {
        return (byte) (a * a);
    }

    public Byte mod(Byte a, Byte b) throws EvaluationException {
        if (b == 0) {
            throw new NonPositiveModException();
        }
        return (byte) (a % b);
    }

    public Byte max(Byte a, Byte b) {
        throw new UnsupportedOperationException();
    }

    public Byte min(Byte a, Byte b) {
        throw new UnsupportedOperationException();
    }

    public Byte zero() {
        return (byte) 0;
    }

    public Byte parseString(String number) throws NumberFormatException {
        return (byte) Integer.parseInt(number);
    }

    public Byte parseInteger(int x) throws NumberFormatException {
        return (byte) x;
    }

    public boolean containsSymbol(char c) {
        return Character.isDigit(c) || c == '-';
    }
}
