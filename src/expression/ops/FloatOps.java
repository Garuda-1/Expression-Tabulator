package expression.ops;

public class FloatOps implements Ops<Float> {
    public Float negate(Float a) {
        return -a;
    }

    public Float add(Float a, Float b) {
        return a + b;
    }

    public Float subtract(Float a, Float b) {
        return a - b;
    }

    public Float multiply(Float a, Float b) {
        return a * b;
    }

    public Float divide(Float a, Float b) {
        return a / b;
    }

    public Float abs(Float a) {
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public Float square(Float a) {
        return a * a;
    }

    public Float mod(Float a, Float b) {
        return a % b;
    }

    public Float max(Float a, Float b) {
        return Float.max(a, b);
    }

    public Float min(Float a, Float b) {
        return Float.min(a, b);
    }

    public Float zero() {
        return (float) 0;
    }

    public Float parseString(String number) throws NumberFormatException {
        return Float.parseFloat(number);
    }

    public Float parseInteger(int x) throws NumberFormatException {
        return (float) x; //Float.parseFloat(Integer.toString(x));
    }

    public boolean containsSymbol(char c) {
        return Character.isDigit(c) || c == '.' || c == 'E' || c == 'e' || c == '-';
    }
}
