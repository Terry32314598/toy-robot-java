package exception;

public class CommandParseFailureException  extends RuntimeException {

    public CommandParseFailureException(String message) {
        super(message);
    }
}