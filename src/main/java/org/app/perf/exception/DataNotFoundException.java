package org.app.perf.exception;

/**
 * Created by gauravbehl on 26/5/17.
 */
public class DataNotFoundException extends Exception {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public DataNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public DataNotFoundException() {
        super();
    }
}
