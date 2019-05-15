package expression.exceptions;

public class UnsupportedOperationException extends EvaluationException {
    public UnsupportedOperationException(String opName, String mode) {
        super("Operation " + opName + " is not supported for " + mode + " mode");
    }
}
