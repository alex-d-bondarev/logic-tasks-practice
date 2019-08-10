package org.parctice.app.collected.longest_substring;


public class SlowRecursiveSubStringsWithCounter implements SubStrings {

    private static int maxFoundLengthCounter = 0;

    public int digSubstrings(String text, String possibleSubstring){
        int possibleSubstringLength = possibleSubstring.length();
        if(possibleSubstringLength <= maxFoundLengthCounter){
            return 0;
        }

        if (text.contains(possibleSubstring)){
            printDebugMessageAbout(text, possibleSubstring);
            maxFoundLengthCounter = possibleSubstringLength;
            return possibleSubstringLength;
        } else if (possibleSubstringLength == 1) {
            return 0;
        } else {
            return Math.max(
                    digSubstrings(text, possibleSubstring.substring(0, possibleSubstringLength - 1)),
                    digSubstrings(text, possibleSubstring.substring(1, possibleSubstringLength)));
        }
    }
}
