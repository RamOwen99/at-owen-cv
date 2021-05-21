package com.oramirez.atowencv.service.implementation;

import com.oramirez.atowencv.exception.CVnotFound;
import com.oramirez.atowencv.exception.ExceptionMessages;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.response.PostResponse;
import com.oramirez.atowencv.repository.CVrepository;
import com.oramirez.atowencv.service.CVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.oramirez.atowencv.exception.ExceptionMessages.CV_BY_ID_NOT_FOUND;

@Service
public class CVserviceImplementation implements CVservice {

    @Autowired
    private CVrepository cVrepository;

    @Override
    public List<CVmodel> getAllCVs() {
        List<CVmodel> userCVs = cVrepository.findAll();

        return userCVs;
    }

    @Override
    public CVmodel getCVbyId(String id) {
        Optional<CVmodel> cvSelected = cVrepository.findById(id);
        if (!cvSelected.isPresent()) {
            throw new CVnotFound(
                String.format(CV_BY_ID_NOT_FOUND.getMessageException(), id)
            );
        }
        return cvSelected.get();
    }

    @Override
    public PostResponse createNewCV(CVmodel request) {
        System.out.println("The request -> " + request);
        CVmodel saveNewCV = cVrepository.save(request);
        System.out.println("Saved = " + saveNewCV);
        return new PostResponse(saveNewCV.getId());
    }

}
