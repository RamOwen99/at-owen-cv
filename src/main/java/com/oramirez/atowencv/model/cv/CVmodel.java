package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class CVmodel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String job;
    private String city;
    private String country;
    private String email;
    private String phoneNumber;
    private List<Skills> skills;
    private List<Languages> languages;
    private List<WorkExperience> workexperience;
    private List<Education> education;
    private List<Challenges> challenges;
    private SocialMedia socialMedia;
    private Config config;
}
