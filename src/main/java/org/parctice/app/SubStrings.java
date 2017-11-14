package org.parctice.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * What is the longest sub-sequence of original String (x) that is substring of another String (y)?
 */

public class SubStrings {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
//        String x = scan.nextLine();
//        String y = scan.nextLine();
        String x = "abcdefgabgq";
        String y = "wabgq";
        if (inputIsCorrect(x, y)){
            codingAssignment(x, y);
        } else {
            System.out.println("Wrong input");
        }
    }

    public static void codingAssignment(String x, String y){
        int longest = 0;
        Set<String> allResults = getAllSubsinquenciesOf(x, y);

        for(String result : allResults){
            if(result.length() > longest){
                longest = result.length();
            }
        }

        System.out.println(allResults);
        System.out.println(longest);
    }

    private static Set<String> getAllSubsinquenciesOf(String originString, String of){
        Set<String> allSubSequencies = new HashSet<>();
        String substring;

        for(int begin = 0; begin < originString.length(); begin++){
            for(int end = originString.length(); end > begin; end --){
                substring = originString.substring(begin, end);
                if(isSubstring(of, substring)) allSubSequencies.add(substring);

                for(int position = 1; position < substring.length(); position++){
                    StringBuffer buffer = new StringBuffer(substring);
                    buffer.deleteCharAt(position);

                    allSubSequencies.addAll(getAllSubsinquenciesOf(buffer.toString(), of));
                }
            }
        }
        return allSubSequencies;
    }

    private static boolean isSubstring(String of, String substring){
        return of.contains(substring);
    }

    private static boolean inputIsCorrect(String x, String y){
        return x != null && y != null
                && constraint1(x) && constraint1(y)
                && constraint2(x) && constraint2(y);
    }

    private static boolean constraint1(String string){
        return !(string.length() < 1 || string.length() > 2000);
    }

    private static boolean constraint2(String string){
        return string.matches(".*[a-z].*");
    }
}