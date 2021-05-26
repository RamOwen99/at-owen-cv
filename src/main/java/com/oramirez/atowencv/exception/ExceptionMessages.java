package com.oramirez.atowencv.exception;

public enum ExceptionMessages {
    CV_BY_ID_NOT_FOUND("The CV with the id %s does not exist"),
    CV_CAN_NOT_UPDATE("The cv with the id %s can not be update, because it doesn't exist"),

    // Messages when a field is invalid
    INVALID_FIELD("The field %s is required"),
    INVALID_EMAIL_FORMAT("The %s does not have the correct format. Try with this format 'example@domain.com'"),
    INVALID_PHONE_NUMBER("The %s is not valid because it is not a phone number"),
    INVALID_TECHNICAL_LANGUAGE_SKILLS_NAME("Invalidate %s name"),
    INVALID_PERCENTAGE_SKILLS("The %s percentage is out of the rank, try in a rank of 1-100"),
    FROM_DATE_AND_TO_ARE_EQUALS("The %s and the %s are equals in %s"),
    FROM_DATE_BIGGER_THAN_TO("%s is a bigger date than %s in %s");

    private final String MESSAGE_EXCEPTION;

    ExceptionMessages(String messageException) {
        this.MESSAGE_EXCEPTION = messageException;
    }

    public String getMessageException() {
        return this.MESSAGE_EXCEPTION;
    }
}

