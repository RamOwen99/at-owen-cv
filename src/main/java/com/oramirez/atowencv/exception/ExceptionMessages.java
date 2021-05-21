package com.oramirez.atowencv.exception;

public enum ExceptionMessages {
    CV_BY_ID_NOT_FOUND("The CV with the id %s does not exist");

    private final String MESSAGE_EXCEPTION;

    ExceptionMessages(String messageException) {
        this.MESSAGE_EXCEPTION = messageException;
    }

    public String getMessageException() {
        return this.MESSAGE_EXCEPTION;
    }
}

