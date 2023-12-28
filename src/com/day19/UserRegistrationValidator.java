package com.day19;

import java.util.regex.*;

public class UserRegistrationValidator {

    public static boolean validateUser(String firstName, String lastName, String email, String mobile, String password) {
        if (!Pattern.matches("[A-Z][a-zA-Z]{2,}", firstName)) {
            return false;
        }

        if (!Pattern.matches("[A-Z][a-zA-Z]{2,}", lastName)) {
            return false;
        }

        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(emailPattern, email)) {
            return false;
        }

        String mobilePattern = "^\\d{2}\\s\\d{10}$";
        if (!Pattern.matches(mobilePattern, mobile)) {
            return false;
        }

        if (!Pattern.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{8,}$", password)) {
            return false;
        }

        return true;
    }

    public static void testSampleEmails() {
        String[] validEmails = {
                "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com",
                "abc111@abc.com", "abc-100@abc.net", "abc.100@abc.com.au",
                "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com"
        };

        String[] invalidEmails = {
                "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
                ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com",
                "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"
        };

        for (String email : validEmails) {
            boolean isValid = validateUser("Vaibhav", "Raut", email, "91 9923774589", "Password1!");
            System.out.println("Validation result for " + email + ": " + isValid);
        }

        for (String email : invalidEmails) {
            boolean isValid = validateUser("Vaibhav", "Raut", email, "91 959354301", "Password1!");
            System.out.println("Validation result for " + email + ": " + isValid);
        }
    }

    public static void main(String[] args) {
        testSampleEmails();
    }
}

