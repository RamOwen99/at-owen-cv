package com.oramirez.atowencv.service;

import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.response.PostResponse;

import java.util.List;

public interface CVservice {
    List<CVmodel> getAllCVs();
    PostResponse createNewCV(CVmodel request);
    CVmodel getCVbyId(String id);
    CVmodel updateCVwithAnId(CVmodel cv, String id);
}
