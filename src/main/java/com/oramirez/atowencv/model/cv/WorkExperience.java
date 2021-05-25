package com.oramirez.atowencv.model.cv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
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

    public String getFrom() {
        if (this.from == null) {
            return null;
        }
        String simpleDateFormat = new SimpleDateFormat("MMMM YYYY").format(this.from);
        return simpleDateFormat;
    }

    public String getTo() {
        if(this.to == null) {
            return null;
        }
        String simpleDateFormat = new SimpleDateFormat("MMMM YYYY").format(this.to);
        return simpleDateFormat;
    }
}
