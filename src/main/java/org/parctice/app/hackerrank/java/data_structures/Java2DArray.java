package org.parctice.app.hackerrank.java.data_structures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

// Input:
// There will be exactly 6 lines, each containing 6 integers separated by spaces.
// Each integer will be between -9 and 9 inclusive.
// Output:
// Print the answer (biggest sum of hour glass) to this problem on a single line.

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int HOURGLASS_SIZE = 3;

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        System.out.println(getBiggestHourGlassSumFrom(arr));
    }

    // Given array is flexible in size,
    // but assuming it is at least 3x3 and is always a rectangle
    // tested on 6x6
    private static int getBiggestHourGlassSumFrom(int[][] array) {
        int maxSum = Integer.MIN_VALUE;
        int newSum;
        for (int i = 0; i <= array.length - HOURGLASS_SIZE; i++) {
            for (int j = 0; j <= array[i].length - HOURGLASS_SIZE; j++) {

                newSum = array[j]    [i] + array[j]    [i + 1] + array[j]    [i + 2]
                                         + array[j + 1][i + 1] +
                       + array[j + 2][i] + array[j + 2][i + 1] + array[j + 2][i + 2];

                maxSum = Math.max(newSum, maxSum);
            }
        }
        return maxSum;
    }

    @Test
    public void testBiggestHourGlass() {
        int[][] testArray = {
                {1, 2, 2, 2},
                {3, 3, 3, 3},
                {1, 4, 4, 4},
                {1, 2, 2, 2}};
        int expectedSum = 21;
        int actualSum = getBiggestHourGlassSumFrom(testArray);
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testBiggestHourGlassOnSmallestArray() {
        int[][] testArray = {
                {1, 2, 2},
                {3, 3, 3},
                {1, 4, 4}};
        int expectedSum = 17;
        int actualSum = getBiggestHourGlassSumFrom(testArray);
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testBiggestHourGlassOnBiggestArrayWithNegatives() {
        int[][] testArray = {
                {1, 2, 2, -4, -5, 9},
                {3, 3, 3, 3, 3, 3},
                {1, 4, 4, 7, 7, 7},
                {-9, -5, 9, 5, 7, 5},
                {3, 3, 3, 7, 7, 7},
                {1, 4, 4, 5, 6, 7},};
        int expectedSum = 49;
        int actualSum = getBiggestHourGlassSumFrom(testArray);
        Assert.assertEquals(expectedSum, actualSum);
    }

}
