package org.parctice.app.hackerrank.java.introduction;

import java.util.Scanner;

public class Loops {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        String outputMessage = "%d x %d = %d";
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format(outputMessage, N, i, N*i));
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();
    }
}
