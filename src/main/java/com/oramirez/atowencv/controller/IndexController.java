package com.oramirez.atowencv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    public String indexController() {
        return "<h1 style=\"margin-top: 3.125rem; font-family: arial; text-align: center;\">" +
                    "Welcome to Owen's cv API. " + "Go to <a href=#>/at-owen-cv/cvs</a> to start" +
                "</h1>";
    }

}
