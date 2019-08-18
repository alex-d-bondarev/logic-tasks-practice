package org.parctice.app.hackerrank.java.strings;

import java.util.Scanner;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String regex = "[A-Za-z !,?._'@]+";

        s = s.trim();

        if (s.length() == 0){
            System.out.println("0");
        }

        if (s.length() < 400000 && s.matches(regex)){
            printTokens(s);
        }

        scan.close();
    }

    private static void printTokens(String string){
        String delimeters = "[ !,?._'@]+";
        String[] tokens = string.split(delimeters);

        System.out.println(tokens.length);

        for(String token : tokens){
            System.out.println(token);
        }
    }
}
