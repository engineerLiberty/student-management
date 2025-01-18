package com.engineerLiberty.techieAssessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {
    @Test
    void testRemoveDuplicates() {
        int[][] input = {
                {1, 3, 1, 2, 3, 4, 4, 3, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {7, 8, 9, 7, 8, 9, 10}
        };

        int[][] expected = {
                {1, 3, 0, 2, 0, 4, 0, 0, 5},
                {1, 0, 0, 0, 0, 0, 0},
                {7, 8, 9, 0, 0, 0, 10}
        };

        RemoveDuplicates.removeDuplicates(input);

        assertArrayEquals(expected, input);
    }

    @Test
    public void testRemoveDuplicates_SimpleCase() {
        // Test with some duplicates
        int[][] input = {
                {1, 3, 1, 2, 3, 4, 4, 3, 5},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int[][] expected = {
                {1, 3, 0, 2, 0, 4, 0, 0, 5},
                {1, 0, 0, 0, 0, 0, 0}
        };

        // Remove duplicates
        RemoveDuplicates.removeDuplicates(input);

        // Assert that the result matches the expected output
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRemoveDuplicates_AllDuplicates() {
        // Test when all elements are the same
        int[][] input = {
                {7, 7, 7, 7},
                {9, 9, 9}
        };
        int[][] expected = {
                {7, 0, 0, 0},
                {9, 0, 0}
        };

        // Remove duplicates
        RemoveDuplicates.removeDuplicates(input);

        // Assert that the result matches the expected output
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRemoveDuplicates_NoDuplicates() {
        // Test when no duplicates are present
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7}
        };
        int[][] expected = {
                {1, 2, 3, 4},
                {5, 6, 7}
        };

        // Remove duplicates
        RemoveDuplicates.removeDuplicates(input);

        // Assert that the result matches the expected output (should remain unchanged)
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRemoveDuplicates_EmptyRow() {
        // Test with an empty row
        int[][] input = {
                {1, 2, 3, 4},
                {}
        };
        int[][] expected = {
                {1, 2, 3, 4},
                {}
        };

        // Remove duplicates
        RemoveDuplicates.removeDuplicates(input);

        // Assert that the result matches the expected output (empty row should remain unchanged)
        assertArrayEquals(expected, input);
    }

    @Test
    public void testRemoveDuplicates_SingleElement() {
        // Test with a single element in the row
        int[][] input = {
                {5},
                {8, 8, 8}
        };
        int[][] expected = {
                {5},
                {8, 0, 0}
        };

        RemoveDuplicates.removeDuplicates(input);

        assertArrayEquals(expected, input);
    }

}