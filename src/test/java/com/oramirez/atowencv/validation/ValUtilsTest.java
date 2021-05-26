package com.oramirez.atowencv.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static com.oramirez.atowencv.validation.ValUtils.*;

public class ValUtilsTest {

    @Test
    public void itShouldBeValidString() {
        assertEquals(true, isValidField("Hello world"));
    }

    @Test
    public void itShouldBeInvalidString() {
        assertEquals(false, isValidField(""));
        assertEquals(false, isValidField(" "));
        assertEquals(false, isValidField("                  "));
        assertEquals(false, isValidField("          "));
        assertEquals(false, isValidField(null));
    }

    @Test
    public void itShouldBeValidPercentageRank() {
        assertEquals(true, isValidPercentageRank((byte) 1));
        assertEquals(true, isValidPercentageRank((byte) 50));
        assertEquals(true, isValidPercentageRank((byte) 80));
        assertEquals(true, isValidPercentageRank((byte) 100));
    }

    @Test
    public void itShouldBeInvalidPercentageRank() {
        assertEquals(false, isValidPercentageRank(null), () -> "When it's null");
        assertEquals(false, isValidPercentageRank((byte) -10), () -> "When it's less than 0");
        assertEquals(false, isValidPercentageRank((byte) -1), () -> "When it's less than 0 (-1)");
        assertEquals(false, isValidPercentageRank((byte) 0), () -> "When it's 0");
        assertEquals(false, isValidPercentageRank((byte) 101), () -> "When it's more that 100");
        assertEquals(false, isValidPercentageRank((byte) 200), () -> "When it's more that 200");

    }

    @Test
    public void itShouldBeValidPhoneNumber() {
        assertEquals(true, isValidPhoneNumber("1234567890"));
        assertEquals(true, isValidPhoneNumber("0987654321"));
    }

    @Test
    public void itShouldBeInvalidPhoneNumber() {
        assertEquals(false, isValidPhoneNumber(null));
        assertEquals(false, isValidPhoneNumber(""));
        assertEquals(false, isValidPhoneNumber(" "));
        assertEquals(false, isValidPhoneNumber("      "));
        assertEquals(false, isValidPhoneNumber("12345"));
        assertEquals(false, isValidPhoneNumber("1"));
        assertEquals(false, isValidPhoneNumber("123456789"));
        assertEquals(false, isValidPhoneNumber("1234567890123"));
    }

    @Test
    public void itShouldBeValidEmail() {
        assertEquals(true,isValidEmail("hello@example.com"));
        assertEquals(true,isValidEmail("hello_world@example.com"));
        assertEquals(true,isValidEmail("hello.world@example.com"));
        assertEquals(true,isValidEmail("helloWorld@example.com"));
    }

    @Test
    public void isShouldBeInvalidEmail(){
        assertEquals(false,isValidEmail(null));
        assertEquals(false,isValidEmail(""));
        assertEquals(false,isValidEmail("     "));
        assertEquals(false,isValidEmail("helloExample"));
        assertEquals(false,isValidEmail("hello@example"));
        assertEquals(false,isValidEmail("helloexample.com"));
    }
}