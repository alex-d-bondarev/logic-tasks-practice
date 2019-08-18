package org.parctice.app.hackerrank.java.strings;

import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

//        For the first line, sum the lengths of A and B.
        System.out.println(A.length()+B.length());

//        For the second line, write Yes if A is lexicographically greater than B otherwise print No instead.
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");

//        For the third line, capitalize the first letter in both A and B and print them on a single line, separated by a space.

        System.out.println(
                A.substring(0,1).toUpperCase() + A.substring(1) + " " +
                B.substring(0,1).toUpperCase() + B.substring(1));
    }


}
