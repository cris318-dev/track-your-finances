package com.cris318_dev.track_your_finances.exceptions;

public class UserAccountListIsNullException extends Exception {
  public UserAccountListIsNullException(){}
    public UserAccountListIsNullException(String message) {
        super(message);
    }
}
