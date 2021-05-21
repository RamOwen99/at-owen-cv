package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {
    private String title;
    private String company;
    private Date from;
    private Date to;
    private Boolean current;
    private String description;
}
