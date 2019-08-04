package org.parctice.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Constraint 1: Input can only contain letters
 * Constraint 2: Input is not empty and can be up to 2000 letters long.
 */
@RunWith(Parameterized.class)
public class SubStringsTest {

    private static final int MAX_LENGTH = 2000;
    private static final String REGEX = "^[a-zA-Z]+$";

    private SubStrings solution;

    public SubStringsTest(SubStrings substr){
        this.solution = substr;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { new SlowSubStrings() }
                // This solution calculates incorrectly
                // and also too slow could not calculate longestSubstringLength for more than 5h 30m
        });
    }

    @Test
    public void longestSubstringLength(){
//        String x = "Never build a dungeon you wouldn’t be happy to spend the night in yourself";
//        String y = "The world would be a happier place if more people remembered that.";
        String x = "abhappcde";
        String y = "ahapp";
        int expectedLength = 4;

        Assert.assertEquals("Expected substring is 'happ', which is 4 chars long",
                expectedLength, solution.getLongestSubstringLength(x, y));
    }

    interface SubStrings{
        int getLongestSubstringLength(String x, String y);
    }

    // extremely slow (initial version)
    static class SlowSubStrings implements SubStrings {

//        public static void main(String args[]){
//        Scanner scan = new Scanner(System.in);
//        String x = scan.nextLine();
//        String y = scan.nextLine();
//            if (inputIsCorrect(x, y)) {
//                getLongestSubstringLength(x, y);
//            } else {
//                System.out.println("Wrong input");
//            }
//        }

        public int getLongestSubstringLength(String x, String y) {
            int longest = 0;
            Set<String> allResults = getAllSubsinquenciesOf(x, y);

            for (String result : allResults) {
                if (result.length() > longest) {
                    longest = result.length();
                }
            }

            System.out.println(allResults);
            System.out.println(longest);

            return longest;
        }

        private static Set<String> getAllSubsinquenciesOf(String originString, String of) {
            Set<String> allSubSequencies = new HashSet<>();
            String substring;

            for (int begin = 0; begin < originString.length(); begin++) {
                for (int end = originString.length(); end > begin; end--) {
                    substring = originString.substring(begin, end);
                    if (isSubstring(of, substring)) allSubSequencies.add(substring);

                    for (int position = 1; position < substring.length(); position++) {
                        StringBuffer buffer = new StringBuffer(substring);
                        buffer.deleteCharAt(position);

                        allSubSequencies.addAll(getAllSubsinquenciesOf(buffer.toString(), of));
                    }
                }
            }
            return allSubSequencies;
        }

        private static boolean isSubstring(String of, String substring) {
            return of.contains(substring);
        }

        private static boolean inputIsCorrect(String x, String y) {
            return x != null && y != null
                    && stringLengthIsBellowMaximum(x) && stringLengthIsBellowMaximum(y)
                    && constraint2(x) && constraint2(y);
        }

        private static boolean stringLengthIsBellowMaximum(String str) {
            return  (str == null || str.length() < 1 || str.length() > MAX_LENGTH);
        }

        private static boolean constraint2(String string) {
            return string.matches(REGEX);
        }

    }
}