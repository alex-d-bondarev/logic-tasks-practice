package org.parctice.app.collected.longest_substring;

public interface SubStrings {
    static final int MAX_LENGTH = 2000;

    default int getLongestSubstringLength(String x, String y) {
        String shorter, longer;

        if (!inputIsCorrect(x, y)) {
            throw new RuntimeException("Stop. The input strings do not meet constraints.");
        }

        if(x.length() > y.length()){
            longer = x;
            shorter = y;
        } else {
            longer = y;
            shorter = x;
        }

        return digSubstrings(longer, shorter);
    }

    default void printDebugMessageAbout(String text, String substring){
        String message = "Found '%s' to contain '%s' with length = %d";
        System.out.println(String.format(message, text, substring, substring.length()));
    }

    default boolean inputIsCorrect(String x, String y) {
        return x != null && y != null
                && stringLengthIsAcceptable(x) && stringLengthIsAcceptable(y);
    }

    default boolean stringLengthIsAcceptable(String str) {
        return  !(str.length() < 1 || str.length() > MAX_LENGTH);
    }

    int digSubstrings(String text, String possibleSubstring);
}
