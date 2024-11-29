package exceptions;

public class CantDecomposeException extends Exception {
    public CantDecomposeException(String name, int n) {
        super("I am not able to decompose " + n + " using " + name + " sequence");
    }
}
