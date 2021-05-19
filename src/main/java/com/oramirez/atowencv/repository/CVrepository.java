package com.oramirez.atowencv.repository;

import com.oramirez.atowencv.model.cv.CVmodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVrepository extends MongoRepository<CVmodel, String> {

    @Override
    List<CVmodel> findAll();

}
