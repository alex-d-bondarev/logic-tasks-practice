package org.parctice.app.collected.count_letters;

import java.util.HashMap;
import java.util.Map;

// This one is the easiest to implement and has average calculation speed
public class SimpleCounter implements Counter{
    public Map<Character, Integer> count(String input){
        Map<Character, Integer> result = new HashMap<>();

        for (char currentLetter : input.toCharArray()){

            if(result.containsKey(currentLetter)){
                int newValue = result.get(currentLetter) + 1;
                result.put(currentLetter, newValue);
            } else {
                result.put(currentLetter, 1);
            }
        }

        return result;
    }
}