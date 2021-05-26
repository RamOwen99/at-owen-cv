package com.oramirez.atowencv.validation.cvValidation;

import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.cv.Education;
import com.oramirez.atowencv.validation.Validate;
import com.oramirez.atowencv.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.oramirez.atowencv.validation.ValUtils.*;
import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.*;

@Service
public class ValidateEducation implements Validate<CVmodel> {
    
    @Override
    public void validate(CVmodel currentCV) {
        validateInstitute(currentCV.getEducation());
        validateCareer(currentCV.getEducation());
        validateDegree(currentCV.getEducation());
        validateDateEducation(currentCV.getEducation());
    }

    private static void validateInstitute(List<Education> educationList) {
        for(Education education : educationList) {
            if(!isValidField(education.getName())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        INSTITUTE.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateCareer(List<Education> educationList) {
        for(Education education : educationList) {
            if(!isValidField(education.getCareer())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        CAREER.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateDegree(List<Education> educationList) {
        for(Education education : educationList) {
            if(!isValidField(education.getDegree())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        DEGREE.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateDateEducation(List<Education> educationList) {
        for(Education education : educationList) {
            if(!isValidField(education.getFrom())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        FROM_DATE.getFieldName()
                    ) +
                    " in " + education.getCareer()
                );
            }
        }
        for(Education education : educationList) {
            if(!isValidField(education.getTo())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_FIELD.getMessageException(),
                        TO_DATE.getFieldName()
                    ) +
                    " in " + education.getCareer()
                );
            }
        }
        for(Education education : educationList) {
            isValidFromToDate(education.getTo(), education.getFrom(), education.getCareer());
        }
    }
}
