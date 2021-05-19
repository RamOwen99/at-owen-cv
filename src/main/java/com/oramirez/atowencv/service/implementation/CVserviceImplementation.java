package com.oramirez.atowencv.service.implementation;

import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.repository.CVrepository;
import com.oramirez.atowencv.service.CVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVserviceImplementation implements CVservice {

    @Autowired
    private CVrepository cVrepository;

    @Override
    public List<CVmodel> getAllCVs() {
        List<CVmodel> userCVs = cVrepository.findAll();

        return userCVs;
    }
}
