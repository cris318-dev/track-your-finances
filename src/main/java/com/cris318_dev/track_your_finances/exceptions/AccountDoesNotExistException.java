package com.cris318_dev.track_your_finances.exceptions;

import com.cris318_dev.track_your_finances.model.Account;

public class AccountDoesNotExistException extends Exception {
    public AccountDoesNotExistException(){}
    public AccountDoesNotExistException(String message) {
        super(message);
    }
}
