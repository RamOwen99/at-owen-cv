package com.oramirez.atowencv.validation.cvValidation;

import com.oramirez.atowencv.exception.BadRequestException;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.cv.WorkExperience;
import com.oramirez.atowencv.validation.Validate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.oramirez.atowencv.validation.ValUtils.*;
import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.*;

@Service
public class ValidateWorkExp  implements Validate<CVmodel> {

    @Override
    public void validate(CVmodel currentCV) {
        validateTitleWork(currentCV.getWorkexperience());
        validateCompany(currentCV.getWorkexperience());
        validateDateWork(currentCV.getWorkexperience());
    }

    private static void validateTitleWork(List<WorkExperience> workExperience) {
        for (WorkExperience work : workExperience) {
            if(!isValidField(work.getTitle())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        TITLE_WORK.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateCompany(List<WorkExperience> workExperience) {
        for (WorkExperience work : workExperience) {
            if(!isValidField(work.getCompany())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        COMPANY_NAME.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateDateWork(List<WorkExperience> workExperience) {
        for (WorkExperience work : workExperience) {
            if(!isValidField(work.getFrom())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        FROM_DATE.getFieldName()
                    ) +
                    " in " + work.getCompany()
                );
            }
        }
        for(WorkExperience work : workExperience) {
            if(work.getTo() != null) {
                isValidFromToDate(work.getTo(), work.getFrom(), work.getCompany());
            }
        }
    }

}
