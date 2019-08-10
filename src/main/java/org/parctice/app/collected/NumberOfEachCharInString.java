package org.parctice.app.collected;

import java.util.Map;
import java.util.TreeMap;

/**
* Print each unique char in String and number of times it is used
*/

public class NumberOfEachCharInString {
    public static void main(String[] args){
        String testString = "Some Hello World Text xxxxxxxxx 26 _-+!~`{} <>\"";
        printNumOfEachCharIn(testString);
    }

    public static void printNumOfEachCharIn(String input){
        Map<Character, Integer> charCounter = new TreeMap();

        for(char c : input.toCharArray()){
            if(charCounter.containsKey(c)){
                charCounter.put(c, charCounter.get(c) + 1);
            } else {
                charCounter.put(c, 1);
            }
        }

        System.out.println("=== printNumOfEachCharIn ===");
        System.out.println(charCounter);
    }
}
