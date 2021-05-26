package com.oramirez.atowencv.enums;

public enum CVfields {
    FIRST_NAME("First name"),
    LAST_NAME("Last Name"),
    JOB("Job"),
    CITY("City"),
    COUNTRY("Country"),
    EMAIL("Email"),
    PHONE_NUMBER("Phone number"),
    TECHNICAL_SKILL("Technical skill"),
    LANGUAGE_SKILL("Language skill"),
    TITLE_WORK("Title work"),
    COMPANY_NAME("Company name"),
    FROM_DATE("From date"),
    TO_DATE("To date"),
    INSTITUTE("Institute"),
    CAREER("Career"),
    DEGREE("Degree");


    private final String FIELD_NAME;

    CVfields(String fieldName) {
        this.FIELD_NAME = fieldName;
    }

    public String getFieldName() {
        return this.FIELD_NAME;
    }

}
