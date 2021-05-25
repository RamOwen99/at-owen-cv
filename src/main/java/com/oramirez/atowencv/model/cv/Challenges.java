package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenges {
    private String name;
    private Date date;
    private String description;
    private String url;

    public String getDate() {
        if (this.date == null) {
            return null;
        }
        String simpleDateFormat = new SimpleDateFormat("MMMM YYYY").format(this.date);
        return simpleDateFormat;
    }
}

