package cloud.bigfito.mediumarticles.exception;

import cloud.bigfito.mediumarticles.exception.custom.*;
import cloud.bigfito.mediumarticles.exception.entity.CustomExceptionEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ArticleExceptionHandler {

    @ExceptionHandler(DatabaseConnectionException.class)
    public ResponseEntity<?> handleDatabaseConnectionException(HttpServletRequest request, DatabaseConnectionException exception) {

        CustomExceptionEntity customExceptionEntity = new CustomExceptionEntity( new Date(),
                                                                                HttpStatus.BAD_REQUEST.value(),
                                                                                request.getServletPath(),
                                                                                null);
        customExceptionEntity.addExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(customExceptionEntity, HttpStatus.SERVICE_UNAVAILABLE);

    }

    @ExceptionHandler(QueryExecutionException.class)
    public ResponseEntity<?> handleQueryExecutionException(HttpServletRequest request, QueryExecutionException exception) {

        CustomExceptionEntity customExceptionEntity = new CustomExceptionEntity( new Date(),
                                                                                HttpStatus.BAD_REQUEST.value(),
                                                                                request.getServletPath(),
                                                                                null);
        customExceptionEntity.addExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(customExceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BadArgumentException.class)
    public ResponseEntity<?> handleBadArgumentException(HttpServletRequest request, BadArgumentException exception) {

        CustomExceptionEntity customExceptionEntity = new CustomExceptionEntity( new Date(),
                                                                                 HttpStatus.BAD_REQUEST.value(),
                                                                                 request.getServletPath(),
                                                                       null);
        customExceptionEntity.addExceptionMessage(exception.getMessage());

        return new ResponseEntity<>(customExceptionEntity, HttpStatus.BAD_REQUEST);
    }

}