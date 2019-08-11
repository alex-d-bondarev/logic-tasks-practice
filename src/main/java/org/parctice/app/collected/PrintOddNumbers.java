package org.parctice.app.collected;

import java.util.Arrays;

/**
 * Print all odd numbers between (including) given numbers
 */

public class PrintOddNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOddNumbersBetween(0,24)));
        System.out.println(Arrays.toString(getOddNumbersBetween(1,15)));
    }

    private static int[] getOddNumbersBetween(int from, int to) {
        int[] result;
        int size;
        int iterator = 0;
        int start = isEven(from) ? from+1 : from;
        int stop = isEven(to) ? to-1 : to;

        size = ((stop - start) / 2) + 1;
        result = new int[size];

        for (int i = start; i <= stop; i+=2){
            result[iterator] = i;
            iterator++;
        }

        return result;
    }

    private static boolean isEven(int number){
        return (number & 1) == 0;
    }
}