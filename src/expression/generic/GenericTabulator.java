package expression.generic;

import expression.TripleExpression;
import expression.exceptions.EvaluationException;
import expression.exceptions.ParserException;
import expression.ops.*;
import expression.parser.ExpressionParser;
import expression.parser.Parser;

public class GenericTabulator implements Tabulator {

    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        Ops<?> ops = null;
        if (mode.compareTo("i") == 0) {
            ops = new IntegerOps();
        }
        if (mode.compareTo("d") == 0) {
            ops = new DoubleOps();
        }
        if (mode.compareTo("bi") == 0) {
            ops = new BigIntegerOps();
        }
        if (mode.compareTo("u") == 0) {
            ops = new UncheckedIntegerOps();
        }
        if (mode.compareTo("f") == 0) {
            ops = new FloatOps();
        }
        if (mode.compareTo("b") == 0) {
            ops = new ByteOps();
        }
        if (ops == null) {
            return null;
        }
        return tabulateInner(ops, expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] tabulateInner(Ops<T> ops, String source, int x1, int x2, int y1, int y2, int z1, int z2) {
        Object[][][] ret = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        Parser<T> expressionParser = new ExpressionParser<>(ops);
        TripleExpression<T> expression;
        try {
            expression = expressionParser.parse(source);
        } catch (ParserException e) {
            return ret;
        }
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        ret[i - x1][j - y1][k - z1] = expression.evaluate(ops.parseInteger(i), ops.parseInteger(j), ops.parseInteger(k));
                    } catch (EvaluationException e) {
                        ret[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return ret;
    }
}
