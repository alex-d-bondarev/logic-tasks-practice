package org.parctice.app.hackerrank.java.strings;

import org.junit.Assert;
import org.junit.Test;

// This task does not allow additional imports

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        if(a.length() == b.length()) {

            char[] aArray = a.toLowerCase().toCharArray();
            char[] bArray = b.toLowerCase().toCharArray();

            a = new String(sortArray(aArray));
            b = new String(sortArray(bArray));

            return a.equals(b);
        } else {
            return false;
        }
    }

    static char[] sortArray(char[] array){
        char tempChar;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0 + i; j < array.length; j++) {
                if (array[i] > array[j]){
                    tempChar = array[i];
                    array[i] = array[j];
                    array[j] = tempChar;
                }
            }
        }

        return array;
    }

    @Test
    public void thisIsAnagram(){
        Assert.assertTrue(isAnagram("anagram", "margana"));
    }

    @Test
    public void thisIsNotAnagram(){
        Assert.assertFalse(isAnagram("anagramm", "marganaa"));
    }

    @Test
    public void thisIsDefinitelyNotAnagram(){
        Assert.assertFalse(isAnagram("anagram", "abc"));
    }
}
