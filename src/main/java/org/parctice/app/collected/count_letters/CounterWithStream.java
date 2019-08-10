package org.parctice.app.collected.count_letters;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

// This one is the slowest on my machine
public class CounterWithStream implements Counter{
    public Map<Character, Integer> count(String input){
        return input.chars().boxed()
                .collect(toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum));
    }
}
