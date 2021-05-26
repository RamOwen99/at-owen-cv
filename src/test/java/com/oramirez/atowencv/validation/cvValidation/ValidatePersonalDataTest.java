package com.oramirez.atowencv.validation.cvValidation;

import com.oramirez.atowencv.exception.BadRequestException;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.validation.cvValidation.ValidatePersonalData;
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
        this.cv.setEmail("cesar@example.com");
        this.cv.setPhoneNumber("0123456789");
    }

    @Test
    public void itShouldThrowBadRequestInFirstName() {
        assertAll(
            () -> {
                this.cv.setFirstName(null);
                Exception exceptionInFirstName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), FIRST_NAME.getFieldName()),
                    exceptionInFirstName.getMessage()
                );
            },
            () -> {
                this.cv.setFirstName("");
                Exception exceptionInFirstName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), FIRST_NAME.getFieldName()),
                    exceptionInFirstName.getMessage()
                );
            },
            () -> {
                this.cv.setFirstName("         ");
                Exception exceptionInFirstName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), FIRST_NAME.getFieldName()),
                    exceptionInFirstName.getMessage()
                );
            }
        );

    }

    @Test
    public void itShouldThrowBadRequestInLastName() {
        assertAll(
            () -> {
                this.cv.setLastName(null);
                Exception exceptionInLastName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), LAST_NAME.getFieldName()),
                    exceptionInLastName.getMessage()
                );
            },
            () -> {
                this.cv.setLastName("");
                Exception exceptionInLastName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), LAST_NAME.getFieldName()),
                    exceptionInLastName.getMessage()
                );
            },
            () -> {
                this.cv.setLastName("       ");
                Exception exceptionInLastName = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), LAST_NAME.getFieldName()),
                    exceptionInLastName.getMessage()
                );
            }
        );
    }

    @Test
    public void itShouldThrowBadRequestInJob() {
        assertAll(
            () -> {
                this.cv.setJob(null);
                Exception exceptionInJob = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), JOB.getFieldName()),
                    exceptionInJob.getMessage()
                );
            },
            () -> {
                this.cv.setJob("");
                Exception exceptionInJob = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), JOB.getFieldName()),
                    exceptionInJob.getMessage()
                );
            },
            () -> {
                this.cv.setJob("       ");
                Exception exceptionInJob = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), JOB.getFieldName()),
                    exceptionInJob.getMessage()
                );
            }
        );
    }

    @Test
    public void itShouldThrowBadRequestInCity() {
        assertAll(
            () -> {
                this.cv.setCity(null);
                Exception exceptionInCity = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), CITY.getFieldName()),
                    exceptionInCity.getMessage()
                );
            },
            () -> {
                this.cv.setCity("");
                Exception exceptionInCity = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), CITY.getFieldName()),
                    exceptionInCity.getMessage()
                );
            },
            () -> {
                this.cv.setCity("       ");
                Exception exceptionInCity = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), CITY.getFieldName()),
                    exceptionInCity.getMessage()
                );
            }
        );
    }

    @Test
    public void itShouldThrowBadRequestInCountry() {
        assertAll(
            () -> {
                this.cv.setCountry(null);
                Exception exceptionInCountry = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), COUNTRY.getFieldName()),
                    exceptionInCountry.getMessage()
                );
            },
            () -> {
                this.cv.setCountry("");
                Exception exceptionInCountry = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), COUNTRY.getFieldName()),
                    exceptionInCountry.getMessage()
                );
            },
            () -> {
                this.cv.setCountry("       ");
                Exception exceptionInCountry = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_FIELD.getMessageException(), COUNTRY.getFieldName()),
                    exceptionInCountry.getMessage()
                );
            }
        );
    }

    @Test
    public void itShouldThrowBadRequestInEmail() {
        assertAll(
            () -> {
                this.cv.setEmail(null);
                Exception exceptionInEmail = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_EMAIL_FORMAT.getMessageException(), EMAIL.getFieldName()),
                    exceptionInEmail.getMessage()
                );
            },
            () -> {
                this.cv.setEmail("");
                Exception exceptionInEmail = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_EMAIL_FORMAT.getMessageException(), EMAIL.getFieldName()),
                    exceptionInEmail.getMessage()
                );
            },
            () -> {
                this.cv.setEmail("hello@example");
                Exception exceptionInEmail = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_EMAIL_FORMAT.getMessageException(), EMAIL.getFieldName()),
                    exceptionInEmail.getMessage()
                );
            },
            () -> {
                this.cv.setEmail("helloexample.com");
                Exception exceptionInEmail = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_EMAIL_FORMAT.getMessageException(), EMAIL.getFieldName()),
                    exceptionInEmail.getMessage()
                );
            },
            () -> {
                this.cv.setEmail("hello@.com");
                Exception exceptionInEmail = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_EMAIL_FORMAT.getMessageException(), EMAIL.getFieldName()),
                    exceptionInEmail.getMessage()
                );
            }
        );
    }

    @Test
    public void itShouldThrowBadRequestInPhoneNumber() {
        assertAll(
            () -> {
                this.cv.setPhoneNumber(null);
                Exception exceptionInPhoneNumber = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                    exceptionInPhoneNumber.getMessage()
                );
            },
            () -> {
                this.cv.setPhoneNumber("");
                Exception exceptionInPhoneNumber = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                    exceptionInPhoneNumber.getMessage()
                );
            },
            () -> {
                this.cv.setPhoneNumber("       ");
                Exception exceptionInPhoneNumber = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                    exceptionInPhoneNumber.getMessage()
                );
            },
            () -> {
                this.cv.setPhoneNumber("123");
                Exception exceptionInPhoneNumber = assertThrows(
                        BadRequestException.class, () -> {
                            validatePersonalData.validate(this.cv);
                        }
                );
                assertEquals(
                        String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                        exceptionInPhoneNumber.getMessage()
                );
            },
            () -> {
                this.cv.setPhoneNumber("123456789");
                Exception exceptionInPhoneNumber = assertThrows(
                        BadRequestException.class, () -> {
                            validatePersonalData.validate(this.cv);
                        }
                );
                assertEquals(
                        String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                        exceptionInPhoneNumber.getMessage()
                );
            },
            () -> {
                this.cv.setPhoneNumber("1234567890123");
                Exception exceptionInPhoneNumber = assertThrows(
                    BadRequestException.class, () -> {
                        validatePersonalData.validate(this.cv);
                    }
                );
                assertEquals(
                    String.format(INVALID_PHONE_NUMBER.getMessageException(), PHONE_NUMBER.getFieldName()),
                    exceptionInPhoneNumber.getMessage()
                );
            }
        );
    }
}