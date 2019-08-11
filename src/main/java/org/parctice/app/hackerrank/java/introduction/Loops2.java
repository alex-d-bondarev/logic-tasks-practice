package org.parctice.app.hackerrank.java.introduction;

import java.util.Scanner;

public class Loops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        StringBuilder result;
        int number;

        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            number = a;
            result = new StringBuilder();

            for (int times = 0; times < n; times++) {
                number += Math.pow(2,times)*b;
                result.append(number).append(" ");
            }

            System.out.println(result);
        }
        in.close();
    }
}
