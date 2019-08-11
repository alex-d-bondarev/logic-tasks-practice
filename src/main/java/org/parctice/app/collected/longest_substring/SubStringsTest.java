package org.parctice.app.collected.longest_substring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.parctice.app.helpers.FileHelper;

import java.util.*;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Constraint 1: Input can only contain letters
 * (skip it for nice test text).
 * Constraint 2: Input is not empty and can be up to 2000 letters long
 */
@RunWith(Parameterized.class)
public class SubStringsTest {

    private SubStrings solution;

    public SubStringsTest(SubStrings substr){
        this.solution = substr;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                // { new SlowRecursiveSubStrings() },
                // This solution is too slow. It did not finish successfully on my machine.
                // { new SlowRecursiveSubStringsWithCounter() },
                // This solution is a bit faster, but still slow. It did not finish successfully on my machine either.
                { new SimpleLoopSubStrings() }, // Works pretty fast, when not using recursion
                { new OptimizedLoopSubStrings() }, // Works pretty fast, when not using recursion
                { new CharArrayLoopSubStrings() } // This solution is from geeksforgeeks.org
        });
    }

    @Test
    public void testFullMatch(){
        String x = "abcdefghigklmnop";
        String y = "abcdefghigklmnop";
        int expectedLength = 16;

        Assert.assertEquals("Expected substring is 'abcdefghigklmnop', which is 16 chars long",
                expectedLength, solution.getLongestSubstringLength(x, y));
    }

    @Test
    public void testWithShortString(){
        String x = "abhappcde";
        String y = "ahapp w";
        int expectedLength = 4;

        Assert.assertEquals("Expected substring is 'happ', which is 4 chars long",
                expectedLength, solution.getLongestSubstringLength(x, y));
    }

    @Test
    public void testWithLongString(){
        String x = "Never build a dungeon you wouldn’t be happy to spend the night in yourself";
        String y = "The world would be a happier place if more people remembered that.";
        int expectedLength = 6;

        Assert.assertEquals("Expected substring is ' would' (with space), which is 6 chars long",
                expectedLength, solution.getLongestSubstringLength(x, y));
    }

    @Test
    public void countHouseThatBuiltJackSeveralTimes(){
        String x = "the dog, That worried the cat, That kill'd the rat, That ate the malt";
        String y = FileHelper.stringFromFileInSameLine("src/main/resources/the_house_that_jack_built.txt");
        int expectedLength = 69;

        int times = 1000;
        List<Long> durations = new ArrayList<>();
        double average;
        String testedCounterName = solution.getClass().getSimpleName();
        String durationMessage = "On average, it took %.3f milliseconds for %s to calculate a text %d times";
        String testMessage = "Expected substring is '%s', which is %d chars long and is repeated in text several times";


        Assert.assertEquals(String.format(testMessage, x, expectedLength),
                expectedLength, solution.getLongestSubstringLength(x, y));


        for (int i = 0; i < times; i++) {
            long startTime = System.nanoTime();
            solution.getLongestSubstringLength(x, y);
            long stopTime = System.nanoTime();
            durations.add(stopTime - startTime);
        }

        average = durations.stream().mapToDouble(d -> d).average().orElse(-1d)/1_000_000;
        System.out.println(String.format(durationMessage, average, testedCounterName, times));
    }
}