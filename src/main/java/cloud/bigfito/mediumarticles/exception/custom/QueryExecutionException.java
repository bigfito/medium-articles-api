package cloud.bigfito.mediumarticles.exception.custom;

import java.sql.SQLException;

public class QueryExecutionException extends RuntimeException {

    public QueryExecutionException(){
        super("The API is not available at this moment.");
    }

    public QueryExecutionException(String message) {
        super(message);
    }
}
