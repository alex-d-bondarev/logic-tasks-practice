package org.parctice.app;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
                { new CounterWithMerge() }
        });
    }

    @Test
    public void returns3Letters(){
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

    interface Counter{
        Map<Character, Integer> count(String input);
    }

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

    static class CounterWithMerge implements Counter{
        public Map<Character, Integer> count(String input){
            Map<Character, Integer> result = new HashMap<>();

            for (char currentLetter : input.toCharArray()){
                result.merge(currentLetter, 1, Integer::sum);
            }

            return result;
        }
    }
}
