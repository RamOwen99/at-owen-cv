package com.oramirez.atowencv.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
