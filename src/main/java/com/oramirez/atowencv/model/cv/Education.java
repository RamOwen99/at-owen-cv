package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private String name;
    private String career;
    private LocalDate from;
    private LocalDate to;
    private Boolean forever;
    private String degree;
}
