package org.parctice.app.collected.count_letters;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.parctice.app.helpers.FileHelper;

import java.util.*;

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
        String whiteFang = FileHelper.stringFromFile("src/main/resources/910.txt");

        for (int i = 0; i < times; i++) {
            long startTime = System.nanoTime();
            counter.count(whiteFang);
            long stopTime = System.nanoTime();
            durations.add(stopTime - startTime);
        }

        average = durations.stream().mapToDouble(d -> d).average().orElse(-1d)/1_000_000;

        System.out.println(String.format(message, average, testedCounterName, times));
    }
}
