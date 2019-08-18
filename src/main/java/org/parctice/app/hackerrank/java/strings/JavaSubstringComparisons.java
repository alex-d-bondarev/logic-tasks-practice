package org.parctice.app.hackerrank.java.strings;

import org.junit.Assert;
import org.junit.Test;

public class JavaSubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest = largest = s.substring(0, k);

        String tempString = "";

        for (int i = 0; i <= s.length() - k; i++) {
            tempString = s.substring(i, i+k);

            if(smallest.compareTo(tempString) > 0){
                smallest = tempString;
            }

            if(largest.compareTo(tempString) < 0){
                largest = tempString;
            }
        }

        return smallest + "\n" + largest;
    }

    @Test
    public void testSmallString(){
        String expected = "a\nb";
        String actual = getSmallestAndLargest("ab", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wholeString(){
        String expected = "ab\nab";
        String actual = getSmallestAndLargest("ab", 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void biggerString(){
        String expected = "abc\nzzz";
        String actual = getSmallestAndLargest("xyzabczzz", 3);

        Assert.assertEquals(expected, actual);
    }
}
