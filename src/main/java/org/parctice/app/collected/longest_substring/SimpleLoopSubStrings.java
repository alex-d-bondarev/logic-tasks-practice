package org.parctice.app.collected.longest_substring;


public class SimpleLoopSubStrings implements SubStrings {

    public int digSubstrings(String text, String possibleSubstring){
        int maxFoundLength = 0;

        for (int beginIndex = 0; beginIndex < possibleSubstring.length(); beginIndex++) {
            for (int endIndex = possibleSubstring.length(); endIndex > beginIndex; endIndex--) {
                String tempSubstring = possibleSubstring.substring(beginIndex, endIndex);
                int tempSubstringLength = tempSubstring.length();

                if(tempSubstringLength > maxFoundLength){
                    if(text.contains(tempSubstring)){
//                        printDebugMessageAbout(text, tempSubstring);
                        maxFoundLength = tempSubstringLength;
                    }
                }
            }
        }

        return maxFoundLength;
    }
}
