package expression.ops;

public class DoubleOps implements Ops<Double> {
    public Double negate(Double a) {
        return -a;
    }

    public Double add(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Double divide(Double a, Double b) {
        return a / b;
    }

    public Double abs(Double a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public Double square(Double a) {
        return a * a;
    }

    public Double mod(Double a, Double b) {
        return a % b;
    }

    public Double max(Double a, Double b) {
        return Double.max(a, b);
    }

    public Double min(Double a, Double b) {
        return Double.min(a, b);
    }

    public Double zero() {
        return (double) 0;
    }

    public Double parseString(String number) throws NumberFormatException {
        return Double.parseDouble(number);
    }

    public Double parseInteger(int x) throws NumberFormatException {
        return Double.parseDouble(Integer.toString(x));
    }

    public boolean containsSymbol(char c) {
        return Character.isDigit(c) || c == '.' || c == 'E' || c == 'e' || c == '-';
    }
}
