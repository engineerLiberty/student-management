package com.engineerLiberty.techieAssessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfDigitsTest {

    @Test
    public void testSumOfDigits_EmptyString() {
        // Test when the input string is empty (should return 0)
        int result = SumOfDigits.sumOfDigits("");
        assertEquals(0, result);
    }

    @Test
    public void testSumOfDigits_SingleDigit() {
        // Test when the input string contains a single digit (should return the digit itself)
        int result = SumOfDigits.sumOfDigits("5");
        assertEquals(5, result);
    }

    @Test
    public void testSumOfDigits_MultipleDigits() {
        // Test when the input string contains multiple digits (should return the sum of those digits)
        int result = SumOfDigits.sumOfDigits("123");
        assertEquals(6, result); // 1 + 2 + 3 = 6
    }

    @Test
    public void testSumOfDigits_WithLeadingZeros() {
        // Test when the input string contains leading zeros (should still return the correct sum)
        int result = SumOfDigits.sumOfDigits("00123");
        assertEquals(6, result); // 0 + 0 + 1 + 2 + 3 = 6
    }

    @Test
    public void testSumOfDigits_LargeNumber() {
        // Test with a large number string
        int result = SumOfDigits.sumOfDigits("9876543210");
        assertEquals(45, result); // 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0 = 45
    }

    @Test
    public void testSumOfDigits_SingleZero() {
        // Test when the input string contains a single zero (should return 0)
        int result = SumOfDigits.sumOfDigits("0");
        assertEquals(0, result);
    }
}