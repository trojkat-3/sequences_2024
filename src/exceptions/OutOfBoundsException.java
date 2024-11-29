package exceptions;

public class OutOfBoundsException extends Exception {
    public OutOfBoundsException(String msg, int n) {
        super("Argument " + n + " exceeds the allowed range. " + msg);
    }
}
