package expression.exceptions;

public class NonPositiveModException extends EvaluationException {
    public NonPositiveModException() {
        super("Second modulo operand must be positive");
    }
}
