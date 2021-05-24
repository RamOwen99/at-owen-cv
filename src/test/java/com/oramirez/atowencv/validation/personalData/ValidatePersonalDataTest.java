package com.oramirez.atowencv.validation.personalData;

import com.oramirez.atowencv.exception.BadRequestException;
import com.oramirez.atowencv.model.cv.CVmodel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.*;

public class ValidatePersonalDataTest {

    private ValidatePersonalData validatePersonalData;
    private CVmodel cv;

    @BeforeEach
    public void initializeObject() {
        this.cv = new CVmodel();
        this.validatePersonalData = new ValidatePersonalData();
        this.cv.setFirstName("cesar");
        this.cv.setLastName("cotorro");
        this.cv.setJob("UI/UX");
        this.cv.setCity("cdmx");
        this.cv.setCountry("Mexico");
    }

    @Test
    public void itShouldThrowBadRequestInFirstName() {
        this.cv.setFirstName("");
        Exception exceptionInFirstName = assertThrows(
            BadRequestException.class, () -> {
            validatePersonalData.validate(cv);
        });
        assertEquals(
            String.format(INVALID_FIELD.getMessageException(), FIRST_NAME.getFieldName()),
            exceptionInFirstName.getMessage()
        );
    }
}