package com.oramirez.atowencv.validation.cvValidation;

import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.validation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CVvalidations implements Validate<CVmodel> {

    @Autowired
    private ValidatePersonalData validatePersonalData;

    @Autowired
    private ValidateSkillsLanguages validateSkillsLanguages;

    @Override
    public void validate(CVmodel currentCV) {
        validatePersonalData.validate(currentCV);
        validateSkillsLanguages.validate(currentCV);
    }
}
