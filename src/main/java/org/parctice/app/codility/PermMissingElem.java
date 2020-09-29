package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermMissingElem {
    public int solution(int[] A) {
        int sum = 0;
        int expectedSum = 0;

        for (int j : A) {
            sum += j;
        }

        for (int i = 1; i <= A.length + 1; i++) {
            expectedSum += i;
        }

        return expectedSum - sum;
    }

    @Test
    public void twoIsMissing() {
        assertEquals(2, solution(new int[]{1}));
    }

    @Test
    public void threeIsMissing() {
        assertEquals(3, solution(new int[]{1, 2}));
    }

    @Test
    public void exampleTest() {
        assertEquals(4, solution(new int[]{2, 3, 1, 5}));
    }

    @Test
    public void teensMissingFourteen() {
        assertEquals(14,
                solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19}));
    }
}
