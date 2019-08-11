package org.parctice.app.hackerrank.java.introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EofTask {

    public static void main(String[] args) {
        String readLine;
        int lineNumber = 1;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while ((readLine = bReader.readLine()) != null){
                System.out.println(lineNumber+" "+readLine);
                lineNumber++;
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
