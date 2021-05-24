package com.oramirez.atowencv.validation.personalData;

import com.oramirez.atowencv.exception.BadRequestException;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.validation.Validate;
import org.springframework.stereotype.Service;

import static com.oramirez.atowencv.validation.ValUtils.*;
import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.*;

@Service
public class ValidatePersonalData implements Validate<CVmodel> {

    @Override
    public void validate(CVmodel currentCV) {
        validateFirstName(currentCV.getFirstName());
        validateLastName(currentCV.getLastName());
        validateJob(currentCV.getJob());
        validateCity(currentCV.getCity());
        validateCountry(currentCV.getCountry());
        validateEmail(currentCV.getEmail());
        validatePhoneNumber(currentCV.getPhoneNumber());
    }

    private static void validateFirstName(String firstName) {
        if(!isValidField(firstName)) {
            throw new BadRequestException(
                String.format(
                    INVALID_FIELD.getMessageException(),
                    FIRST_NAME.getFieldName()
                )
            );
        }
    }

    private static void validateLastName(String lastName) {
        if(!isValidField(lastName)) {
            throw new BadRequestException(
                String.format(
                    INVALID_FIELD.getMessageException(),
                    LAST_NAME.getFieldName()
                )
            );
        }
    }

    private static void validateJob(String job) {
        if(!isValidField(job)) {
            throw new BadRequestException(
                String.format(
                    INVALID_FIELD.getMessageException(),
                    JOB.getFieldName()
                )
            );
        }
    }

    private static void validateCity(String city) {
        if(!isValidField(city)) {
            throw new BadRequestException(
                String.format(
                    INVALID_FIELD.getMessageException(),
                    CITY.getFieldName()
                )
            );
        }
    }

    private static void validateCountry(String country) {
        if(!isValidField(country)) {
            throw new BadRequestException(
                String.format(
                    INVALID_FIELD.getMessageException(),
                    COUNTRY.getFieldName()
                )
            );
        }
    }

    private static void validateEmail(String email) {
        if(!isValidEmail(email)) {
            throw new BadRequestException(
                String.format(
                    INVALID_EMAIL_FORMAT.getMessageException(),
                    EMAIL.getFieldName()
                )
            );
        }
    }

    private static void validatePhoneNumber(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) {
            throw new BadRequestException(
                String.format(
                    INVALID_PHONE_NUMBER.getMessageException(),
                    PHONE_NUMBER.getFieldName()
                )
            );
        }
    }
}
