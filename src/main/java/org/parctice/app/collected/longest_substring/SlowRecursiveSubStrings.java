package org.parctice.app.collected.longest_substring;


public class SlowRecursiveSubStrings implements SubStrings {

    public int digSubstrings(String text, String possibleSubstring){
        int possibleSubstringLength = possibleSubstring.length();
        if (text.contains(possibleSubstring)){
            printDebugMessageAbout(text, possibleSubstring);
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
