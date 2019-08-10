package org.parctice.app.collected;

import java.util.Arrays;

/**
 * Push all given numbers to the end of array
 */

public class PushNumber {
    public static void main(String[] args){
        int testArray[] = {0, 1, 2, 3, 0, 4, 5, 0, 0, 0, 6, 0, 0};
        int numToPush = 0;
        System.out.println(Arrays.toString(pushArrayNumberToEnd(testArray, numToPush)));
    }

    public static int[] pushArrayNumberToEnd(int[] array, int number){
        int arrayLength = array.length;
        int counter = 0;
        for(int i = 0 ; i < arrayLength; i++){
            array[counter] = array[i];
            if(array[i] != number)
                counter++;
        }

        while (counter < arrayLength)
            array[counter++] = 0;

        return array;
    }
}
