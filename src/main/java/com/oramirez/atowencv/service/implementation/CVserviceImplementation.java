package com.oramirez.atowencv.service.implementation;

import com.oramirez.atowencv.exception.CVnotFound;
import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.response.PostResponse;
import com.oramirez.atowencv.repository.CVrepository;
import com.oramirez.atowencv.service.CVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.oramirez.atowencv.exception.ExceptionMessages.CV_BY_ID_NOT_FOUND;
import static com.oramirez.atowencv.exception.ExceptionMessages.CV_CAN_NOT_UPDATE;

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
        CVmodel saveNewCV = cVrepository.save(request);
        return new PostResponse(saveNewCV.getId());
    }

    @Override
    public CVmodel updateCVwithAnId(CVmodel cv, String id) {
        CVmodel updatedCV = cv;
        Optional<CVmodel> CVselected = cVrepository.findById(id);
        if(CVselected.isPresent()){
            updatedCV.setId(id);
            updatedCV.setFirstName(cv.getFirstName());
            updatedCV.setLastName(cv.getLastName());
            updatedCV.setJob(cv.getJob());
            updatedCV.setCity(cv.getCity());
            updatedCV.setCountry(cv.getCountry());
            updatedCV.setEmail(cv.getEmail());
            updatedCV.setPhoneNumber(cv.getPhoneNumber());
            updatedCV.setSkills(cv.getSkills());
            updatedCV.setLanguages(cv.getLanguages());
            updatedCV.setWorkexperience(cv.getWorkexperience());
            updatedCV.setEducation(cv.getEducation());
            updatedCV.setChallenges(cv.getChallenges());
            updatedCV.setSocialMedia(cv.getSocialMedia());
            updatedCV.setConfig(cv.getConfig());
            return cVrepository.save(updatedCV);
        }
        throw new CVnotFound(
                String.format(CV_CAN_NOT_UPDATE.getMessageException(), id)
        );
    }

}
