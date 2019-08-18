package org.parctice.app.hackerrank.java.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        System.out.println(isPalindrome(A) ? "Yes" : "No");

    }

    private static boolean isPalindrome(String string){
        boolean isPalindrome = true;

        for (int i = 0; i < Math.ceil(string.length() / 2) && isPalindrome; i++) {
            isPalindrome = (string.charAt(i) == string.charAt(string.length() - i - 1));
        }


        return isPalindrome;
    }

    @Test
    public void madamIsPalindrome(){
        Assert.assertTrue(isPalindrome("madam"));
    }

    @Test
    public void abcdeIsNotPalindrome(){
        Assert.assertFalse(isPalindrome("abcde"));
    }
}
