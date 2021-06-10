package igraciarena.poc.msinvoices.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Exception> notFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
