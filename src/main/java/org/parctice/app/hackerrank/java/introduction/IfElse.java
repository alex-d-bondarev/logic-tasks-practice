package org.parctice.app.hackerrank.java.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfElse {

    public static void main(String[] args) {
        String readLine;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while ((readLine = bReader.readLine()) != null){
                executeTask(Integer.parseInt(readLine));
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void executeTask(int in){
        if(isOdd(in) || (in >= 6 && in <= 20)){
            System.out.println("Weird");
        } else if ((in >= 2 && in <= 5) || in > 20){
            System.out.println("Not Weird");
        }

    }

    private static boolean isOdd(int number){
        return (number & 1) != 0;
    }
}
