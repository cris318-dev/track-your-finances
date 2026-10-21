package com.cris318_dev.track_your_finances.exceptions;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException(){}
    public UserDoesNotExistException(String message) {
        super(message);
    }
}
