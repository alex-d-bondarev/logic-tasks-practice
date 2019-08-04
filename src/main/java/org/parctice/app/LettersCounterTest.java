package org.parctice.app;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/*
Given a String.
Return how many times each letter appeared there
* */
@RunWith(Parameterized.class)
public class LettersCounterTest {

    private Counter counter;

    public LettersCounterTest(Counter counter){
        this.counter = counter;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { new SimpleCounter() },
                { new CounterWithMerge() },
                { new CounterWithStream() }
        });
    }

    @Test
    public void returnsExpectedAmountOfLetters(){
        Map<Character, Integer> count = counter.count("abc");

        assertThat("Map size should equal number of unique letters. For 'abc' that is 3",
                count.size(), is(3));
    }

    @Test
    public void hasExpectedKeys(){
        Map<Character, Integer> count = counter.count("abc");

        assertThat(count, IsMapContaining.hasKey('a'));
        assertThat(count, IsMapContaining.hasKey('b'));
        assertThat(count, IsMapContaining.hasKey('c'));
    }

    @Test
    public void hasNoDuplicates(){
        Map<Character, Integer> count = counter.count("abc");

        assertThat(count, IsMapContaining.hasValue(1));
        assertThat(count, not(IsMapContaining.hasValue(2)));
    }

    @Test
    public void hasExactEntries(){
        Map<Character, Integer> count = counter.count("acdc");

        assertThat(count, IsMapContaining.hasEntry('a', 1));
        assertThat(count, IsMapContaining.hasEntry('c', 2));
        assertThat(count, IsMapContaining.hasEntry('d', 1));
    }

    @Test
    public void isCaseSensitive(){
        Map<Character, Integer> count = counter.count("AAa");

        assertThat(count, IsMapContaining.hasEntry('a', 1));
        assertThat(count, IsMapContaining.hasEntry('A', 2));
    }

    @Test
    public void spacesAreCounted(){
        Map<Character, Integer> count = counter.count("a b c");

        assertThat(count, IsMapContaining.hasEntry(' ', 2));
    }

    @Test
    public void calculateBigFile(){
        int times = 1000;
        List<Long> durations = new ArrayList<>();
        double average;
        String message = "On average, it took %.3f milliseconds for %s to calculate a text %d times";
        String testedCounterName = counter.getClass().getSimpleName();
        String whiteFang = stringFromFile("src/main/resources/910.txt");

        for (int i = 0; i < times; i++) {
            long startTime = System.nanoTime();
            counter.count(whiteFang);
            long stopTime = System.nanoTime();
            durations.add(stopTime - startTime);
        }

        average = durations.stream().mapToDouble(d -> d).average().orElse(-1d)/1_000_000;

        System.out.println(String.format(message, average, testedCounterName, times));
    }

    // credit to https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
    private static String stringFromFile(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    interface Counter{
        Map<Character, Integer> count(String input);
    }

    // This one is the easiest to implement and has average calculation speed
    static class SimpleCounter implements Counter{
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

    // This one is the fastest on my machine
    static class CounterWithMerge implements Counter{
        public Map<Character, Integer> count(String input){
            Map<Character, Integer> result = new HashMap<>();

            for (char currentLetter : input.toCharArray()){
                result.merge(currentLetter, 1, Integer::sum);
            }

            return result;
        }
    }

    // This one is the slowest on my machine
    static class CounterWithStream implements Counter{
        public Map<Character, Integer> count(String input){
            return input.chars().boxed()
                    .collect(toMap(
                            k -> (char) k.intValue(),
                            v -> 1,
                            Integer::sum));
        }
    }
}
