package cloud.bigfito.mediumarticles.exception.custom;


public class DatabaseConnectionException extends RuntimeException {

    public DatabaseConnectionException(){
        super("The API is not available at this moment.");
    }

    public DatabaseConnectionException(String message) {
        super(message);
    }
}