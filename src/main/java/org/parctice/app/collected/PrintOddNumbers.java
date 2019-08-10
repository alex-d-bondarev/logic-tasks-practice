package org.parctice.app.collected;

import java.util.Arrays;

/**
 * Print all odd numbers between (including) given numbers
 */

public class PrintOddNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(oddNumbers(0,24)));
    }



    static int[] oddNumbers(int l, int r) {
        int[] result;
        int size;
        int iterator = 0;
        int start = ((l & 1) == 0) ? l+1 : l;
        int stop = ((r & 1) == 0) ? r-1 : r;

        size = ((stop - start) / 2) + 1;

        result = new int[size];

        for (int i = start; i <= stop; i+=2){
            result[iterator] = i;
            iterator++;
        }

        return result;
    }
}