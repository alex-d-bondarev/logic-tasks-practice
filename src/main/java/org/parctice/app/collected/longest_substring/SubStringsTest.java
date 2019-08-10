package org.parctice.app.collected.longest_substring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
                { new SimpleLoopSubStrings() } // This Solution runs testWithLongString pretty fast
        });
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
}