package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingInteger {
    public int solution(int[] A) {
        boolean[] didOccur = new boolean[A.length + 2];

        for (int x : A) {
            if (x <= A.length && x > 0)
                didOccur[x] = true;
        }

        for (int i = 1; i < didOccur.length; i++) {
            if (!didOccur[i])
                return i;
        }

        return 1;
    }

    @Test
    public void emptyArrayResultsInOne() {
        assertEquals(1, solution(new int[]{}));
    }

    @Test
    public void arrayOfNegativeNumbersResultsInOne() {
        assertEquals(1, solution(new int[]{-2, -1, -3}));
    }

    @Test
    public void arrayOfPositiveNumbersWithoutOne() {
        assertEquals(1, solution(new int[]{2, 3, 4, 5}));
    }

    @Test
    public void arrayOfPositiveNumbersWithoutTwo() {
        assertEquals(2, solution(new int[]{1, 3, 4, 5}));
    }

    @Test
    public void iterateThroughPositiveNumbers() {
        assertEquals(6, solution(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void exampleTest() {
        assertEquals(5, solution(new int[]{1, 3, 6, 4, 1, 2}));
    }
}
