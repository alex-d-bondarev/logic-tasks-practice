package org.parctice.app.collected;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Given a number between 0 and 15.
 * Return factorial position of this number
 * stop, when given number is not between 0 and 15
 */

public class SimpleFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int number = scan.nextInt();
            if(terminate(number)) break;
            System.out.println(findFactorial(number));
        }
    }

    private static long findFactorial(int number){
        long factorial = 1;
        if(number != 0){
            for(int multiplier = 1; multiplier <= number; multiplier++){
                factorial *= multiplier;
            }
        }
        return factorial;
    }


    private static boolean terminate(int number){
        return !(number < 0 || number > 16);
    }

    @Test
    public void zeroNumberIs1() {
        Assert.assertEquals(1, findFactorial(0));
    }

    @Test
    public void firstNumberIsAlso1(){
        Assert.assertEquals(1, findFactorial(1));
    }

    @Test
    public void secondNumberIs2(){
        Assert.assertEquals(2, findFactorial(2));
    }

    @Test
    public void fifthNumberIs120(){
        Assert.assertEquals(120, findFactorial(5));
    }

    @Test
    public void fifteenthNumberIsBig(){
        Assert.assertEquals(1_307_674_368_000L, findFactorial(15));
    }
}