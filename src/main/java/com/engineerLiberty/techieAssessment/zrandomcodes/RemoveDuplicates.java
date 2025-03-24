package com.engineerLiberty.techieAssessment.zrandomcodes;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void removeDuplicates(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            List<Integer> seen = new ArrayList<>();

            for (int j = 0; j < array[i].length; j++) {
                int currentElement = array[i][j];

                boolean isDuplicate = false;
                for (int k = 0; k < seen.size(); k++) {
                    if (seen.get(k) == currentElement) {
                        isDuplicate = true;
                        break;
                    }
                }

                // If it's a duplicate, replace with 0, otherwise add to seen list
                if (isDuplicate) {
                    array[i][j] = 0;
                } else {
                    seen.add(currentElement);
                }
            }
        }
    }

    public static void printArray(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Sample Input
        int[][] array = {
                {1, 3, 1, 2, 3, 4, 4, 3, 5},
                {1, 1, 1, 1, 1, 1, 1}
        };

        // Print input array
        System.out.println("Input Array:");
        printArray(array);

        // Remove duplicates from each row
        removeDuplicates(array);

        // Print result
        System.out.println("\nOutput Array:");
        printArray(array);
    }
}
