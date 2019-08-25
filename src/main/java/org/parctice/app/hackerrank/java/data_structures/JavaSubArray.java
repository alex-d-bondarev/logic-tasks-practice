package org.parctice.app.hackerrank.java.data_structures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class JavaSubArray {

    public static void main(String[] args) {
        System.out.println(getNumOfNegativeSubArraysFrom(getArrayFromScanner()));
    }

    private static int getNumOfNegativeSubArraysFrom(int[] array){
        int numOfNegatives = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length; j >= i ; j--) {
                if(!isPositive(Arrays.copyOfRange(array, i, j))){
                    numOfNegatives++;
                }
            }
        }

        return numOfNegatives;
    }

    private static boolean isPositive(int[] array){
        return Arrays.stream(array).sum() >=  0;
    }


    private static int[] getArrayFromScanner(){
        Scanner scan = new Scanner(System.in);
        int arrayLength = scan.nextInt();
        int[] scannedArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            scannedArray[i] = scan.nextInt();
        }

        return scannedArray;
    }

    @Test
    public void noNegativeSubArrays(){
        int[] onlyPositives = {1, 2, 3, 4, 5};
        int noNegatives = 0;

        Assert.assertEquals(noNegatives, getNumOfNegativeSubArraysFrom(onlyPositives));
    }

    @Test
    public void allNegatives(){
        int[] onlyNegatives = {-1, -2, -3};
        int allSubArrays = 6;

        Assert.assertEquals(allSubArrays, getNumOfNegativeSubArraysFrom(onlyNegatives));
    }

    @Test
    public void combineSubArrays(){
        int[] onlyNegatives = {1, -2, 4, -5, 1};
        int onlyNegativeSubArrays = 9;

        Assert.assertEquals(onlyNegativeSubArrays, getNumOfNegativeSubArraysFrom(onlyNegatives));
    }

    @Test
    public void zeroIsPositive(){
        int[] positiveArray = {0,0,0,-1,1};
        Assert.assertTrue(isPositive(positiveArray));
    }

    @Test
    public void arrayIsPositive(){
        int[] positiveArray = {1, 2, 3, -5};
        Assert.assertTrue(isPositive(positiveArray));
    }

    @Test
    public void arrayIsNegative(){
        int[] positiveArray = {1, 2, -3, -5};
        Assert.assertFalse(isPositive(positiveArray));
    }
}
