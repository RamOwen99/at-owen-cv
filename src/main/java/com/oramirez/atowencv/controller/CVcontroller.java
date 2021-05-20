package com.oramirez.atowencv.controller;

import com.oramirez.atowencv.model.cv.CVmodel;
import com.oramirez.atowencv.model.response.PostResponse;
import com.oramirez.atowencv.service.CVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/at-owen-cv")
public class CVcontroller {

    @Autowired
    private CVservice cVservice;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CVmodel> getAllCVs() {
        return cVservice.getAllCVs();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cv", consumes = "application/json", produces = "application/json")
    public PostResponse createNewCV(@RequestBody CVmodel request) {
        return cVservice.createNewCV(request);
    }
}
