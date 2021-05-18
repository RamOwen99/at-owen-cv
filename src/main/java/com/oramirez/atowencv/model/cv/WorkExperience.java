package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {
    private String title;
    private String company;
    private LocalDate from;
    private LocalDate to;
    private Boolean current;
    private String description;
}
