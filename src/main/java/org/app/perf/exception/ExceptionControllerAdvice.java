package org.app.perf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by gauravbehl on 25/5/17.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerExceptionHandler(NullPointerException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity dataNotFounderExceptionHandler(DataNotFoundException ex) {
        return new ResponseEntity(ex.getErrorMessage(), HttpStatus.NO_CONTENT);
    }

}
