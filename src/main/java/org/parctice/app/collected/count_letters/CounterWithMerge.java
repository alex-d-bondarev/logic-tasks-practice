package org.parctice.app.collected.count_letters;

import java.util.HashMap;
import java.util.Map;

// This one is the fastest on my machine
public class CounterWithMerge implements Counter{
    public Map<Character, Integer> count(String input){
        Map<Character, Integer> result = new HashMap<>();

        for (char currentLetter : input.toCharArray()){
            result.merge(currentLetter, 1, Integer::sum);
        }

        return result;
    }
}
