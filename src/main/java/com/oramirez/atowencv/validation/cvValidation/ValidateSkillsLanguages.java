package com.oramirez.atowencv.validation.cvValidation;

import com.oramirez.atowencv.exception.BadRequestException;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.cv.Languages;
import com.oramirez.atowencv.model.cv.Skills;
import com.oramirez.atowencv.validation.Validate;
import org.springframework.stereotype.Service;

import static com.oramirez.atowencv.validation.ValUtils.*;
import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.*;

import java.util.List;

@Service
public class ValidateSkillsLanguages implements Validate<CVmodel> {

    @Override
    public void validate(CVmodel currentCV) {
        validateSkillsFields(currentCV.getSkills());
        validateLanguageFields(currentCV.getLanguages());
    }

    private static void validateSkillsFields(List<Skills> skills) {
        for (Skills skill : skills) {
            if (!isValidField(skill.getName())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_TECHNICAL_LANGUAGE_SKILLS_NAME.getMessageException(),
                        TECHNICAL_SKILL.getFieldName()
                    )
                );
            }
            if(!isValidPercentageRank(skill.getPercentage())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_PERCENTAGE_SKILLS.getMessageException(),
                        TECHNICAL_SKILL.getFieldName()
                    )
                );
            }
        }
    }

    private static void validateLanguageFields(List<Languages> languages) {
        for (Languages language : languages) {
            if (!isValidField(language.getName())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_TECHNICAL_LANGUAGE_SKILLS_NAME.getMessageException(),
                        LANGUAGE_SKILL.getFieldName()
                    )
                );
            }
            if(!isValidPercentageRank(language.getPercentage())) {
                throw new BadRequestException(
                    String.format(
                        INVALID_PERCENTAGE_SKILLS.getMessageException(),
                        LANGUAGE_SKILL.getFieldName()
                    )
                );
            }
        }
    }
}
