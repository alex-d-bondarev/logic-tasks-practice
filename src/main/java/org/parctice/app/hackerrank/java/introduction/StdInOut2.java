package org.parctice.app.hackerrank.java.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInOut2 {

    public static void main(String[] args) {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int i = Integer.parseInt(bReader.readLine());
            double d = Double.parseDouble(bReader.readLine());
            String s = bReader.readLine();

            System.out.println("String: " + s);
            System.out.println("Double: " + d);
            System.out.println("Int: " + i);
        } catch (IOException e) { e.printStackTrace(); }
    }

}
