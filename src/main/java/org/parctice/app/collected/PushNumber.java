package org.parctice.app.collected;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Push all given numbers to the end of array
 */

public class PushNumber {
    public static void main(String[] args) {
        int testArray[] = {0, 1, 2, 3, 0, 4, 5, 6, 0, 9};
        int num1ToPush = 7;
        int num2ToPush = 6;
        int num3ToPush = 5;

        System.out.println("First try was: \n" +
                Arrays.toString(pushArrayNumberToEnd(testArray,
                        num1ToPush, num2ToPush, num3ToPush)));

        System.out.println("But this looks better: \n" +
                Arrays.toString(pushArrayNumberToEndViaStream(testArray,
                        num1ToPush, num2ToPush, num3ToPush)));
    }

    public static int[] pushArrayNumberToEnd(int[] array, int... numbers) {

        int[] newArray = new int[array.length + numbers.length];

        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(numbers, 0, newArray, array.length, numbers.length);

        return newArray;
    }

    public static int[] pushArrayNumberToEndViaStream(int[] array, int... numbers) {
        return IntStream.concat(Arrays.stream(array), Arrays.stream(numbers)).toArray();
    }
}
