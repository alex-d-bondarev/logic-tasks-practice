package org.parctice.app.hackerrank.java;

import java.util.Scanner;

public class OutputFormating {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.println(getLeftAlignedTextWith15Spaces(s1)
                    .concat(getNumberWithPreceedingZeros(x)));
        }
        System.out.println("================================");
    }

    private static String getLeftAlignedTextWith15Spaces(String in){
        return String.format("%-15s", in);
    }

    private static String getNumberWithPreceedingZeros(int in){
        return String.format("%03d", in);
    }
}
