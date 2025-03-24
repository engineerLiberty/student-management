package com.engineerLiberty.techieAssessment;

import com.engineerLiberty.techieAssessment.zrandomcodes.TimeInWords;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeInWordsTest {

    @Test
    public void testTimeInWords_Case1() {

        String result = TimeInWords.timeInWords(5, 0);
        assertEquals("five o'clock", result);
    }

    @Test
    public void testTimeInWords_Case2() {

        String result = TimeInWords.timeInWords(5, 1);
        assertEquals("one minute past five", result);
    }

    @Test
    public void testTimeInWords_Case3() {

        String result = TimeInWords.timeInWords(5, 15);
        assertEquals("fifteen past five", result);
    }

    @Test
    public void testTimeInWords_Case4() {

        String result = TimeInWords.timeInWords(5, 10);
        assertEquals("ten minutes past five", result);
    }

    @Test
    public void testTimeInWords_Case5() {

        String result = TimeInWords.timeInWords(5, 30);
        assertEquals("half past five", result);
    }

    @Test
    public void testTimeInWords_Case6() {

        String result = TimeInWords.timeInWords(5, 59);
        assertEquals("one minute to six", result);
    }

    @Test
    public void testTimeInWords_Case7() {

        String result = TimeInWords.timeInWords(5, 45);
        assertEquals("quarter to six", result);
    }

    @Test
    public void testTimeInWords_Case8() {

        String result = TimeInWords.timeInWords(5, 50);
        assertEquals("ten minutes to six", result);
    }

    @Test
    public void testTimeInWords_Case9() {

        String result = TimeInWords.timeInWords(12, 0);
        assertEquals("twelve o'clock", result);
    }

}