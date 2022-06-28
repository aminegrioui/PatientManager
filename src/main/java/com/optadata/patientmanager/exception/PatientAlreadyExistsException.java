package com.optadata.patientmanager.exception;

public class PatientAlreadyExistsException extends RuntimeException {
    private String message;

    public PatientAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }

    public PatientAlreadyExistsException() {
    }
}
