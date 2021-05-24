package com.oramirez.atowencv.exception;

public enum ExceptionMessages {
    CV_BY_ID_NOT_FOUND("The CV with the id %s does not exist"),
    CV_CAN_NOT_UPDATE("The cv with the id %s can not be update, because it doesn't exist"),

    // Messages when a field is invalid
    INVALID_FIELD("The field %s is not valid"),
    INVALID_EMAIL_FORMAT("The %s does not have the correct format. Try with this format \"example@domain.com\""),
    INVALID_PHONE_NUMBER("The %s is not valid because it is not a phone number");

    private final String MESSAGE_EXCEPTION;

    ExceptionMessages(String messageException) {
        this.MESSAGE_EXCEPTION = messageException;
    }

    public String getMessageException() {
        return this.MESSAGE_EXCEPTION;
    }
}

