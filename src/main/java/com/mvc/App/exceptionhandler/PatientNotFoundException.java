package com.mvc.App.exceptionhandler;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super();
    }

    public PatientNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PatientNotFoundException(final String message) {
        super(message);
    }

    public PatientNotFoundException(final Throwable cause) {
        super(cause);
    }



}
