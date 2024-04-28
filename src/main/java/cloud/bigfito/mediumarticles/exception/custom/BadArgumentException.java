package cloud.bigfito.mediumarticles.exception.custom;


public class BadArgumentException extends RuntimeException {

    public BadArgumentException() {
        super("The ID parameter must be a positive number of type LONG.");
    }

    public BadArgumentException(String message) {
        super(message);
    }

    public BadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}
