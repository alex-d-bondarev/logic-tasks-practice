package org.parctice.app.hackerrank.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StdInOut {

    public static void main(String[] args) {
        String readLine;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while ((readLine = bReader.readLine()) != null){
                System.out.println(readLine);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

}
