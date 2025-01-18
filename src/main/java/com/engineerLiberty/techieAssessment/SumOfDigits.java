package com.engineerLiberty.techieAssessment;

public class SumOfDigits {

    public static int sumOfDigits(String str) {

        if (str.isEmpty()) {
            return 0;
        }

        int firstDigit = str.charAt(0) - '0';  // Convert char to int

        // Recursive call on the rest of the string
        return firstDigit + sumOfDigits(str.substring(1));
    }

}
