package com.oramirez.atowencv.validation;

import com.oramirez.atowencv.exception.BadRequestException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.oramirez.atowencv.exception.ExceptionMessages.*;
import static com.oramirez.atowencv.enums.CVfields.FROM_DATE;
import static com.oramirez.atowencv.enums.CVfields.TO_DATE;


public class ValUtils {
    public static boolean isValidField(String str) {
        if(str == null || str.trim().equals("")) {
            return false;
        }
        return true;
    }

    public static boolean isValidPercentageRank(Byte percentage) {
        if(percentage == null || percentage < 1 || percentage > 100) {
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String number) {
        if(!isValidField(number)) {
            return false;
        }
        Pattern patternPhone = Pattern.compile("^[0-9]{10}$");
        Matcher matcherPhone = patternPhone.matcher(number);
        return matcherPhone.find();
    }

    public static boolean isValidEmail(String email) {
        if(!isValidField(email)) {
            return false;
        }
        Pattern patternEmail = Pattern.compile(
                "^[\\p{L}\\p{N}\\._%+-]+@[\\p{L}\\p{N}\\.\\-]+\\.[\\p{L}]{2,}$"
        );
        Matcher matcherEmail = patternEmail.matcher(email);
        return matcherEmail.find();
    }

    public static void isValidFromToDate(String to, String from, String companyInstitute) {
        if(to.compareTo(from) == 0) {
            throw new BadRequestException(
                String.format(
                    FROM_DATE_AND_TO_ARE_EQUALS.getMessageException(),
                    FROM_DATE.getFieldName(),
                    TO_DATE.getFieldName(),
                    companyInstitute
                )
            );
        }
        if(to.compareTo(from) < 0) {
            throw new BadRequestException(
                String.format(
                    FROM_DATE_BIGGER_THAN_TO.getMessageException(),
                    FROM_DATE.getFieldName(),
                    TO_DATE.getFieldName(),
                    companyInstitute
                )
            );
        }
    }
}
