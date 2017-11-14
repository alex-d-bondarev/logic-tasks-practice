package org.parctice.app;

import java.util.Scanner;

/**
 * Print simple factorial
 */

public class SimpleFactorial {
    // Assignment
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int number = scan.nextInt();
            if(terminate(number)) break;
            findFactorial(number);
        }
    }

    // self-explanatory
    private static void findFactorial(int number){
        int factorial = 1;
        if(number != 0){
            for(int multiplier = 1; multiplier < number; multiplier++){
                factorial *= multiplier;
            }
        }
        System.out.println(factorial);
    }

    /**
     * @param number    int, number to check
     * @return          boolean, true if input is 1 <= input <= 15, else false
     */
    private static boolean terminate(int number){
        return !(number < 0 || number > 16);
    }
}