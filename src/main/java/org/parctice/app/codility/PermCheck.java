package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermCheck {
    public int solution(int[] A) {
        boolean[] occurred = new boolean[A.length];

        for (int x : A) {
            if (x > 0 && x <= A.length) {
                occurred[x - 1] = true;
            } else {
                return 0;
            }
        }

        for (boolean o : occurred) {
            if (!o) {
                return 0;
            }
        }

        return 1;
    }

    @Test
    public void arrayOfOneIsPermutation() {
        assertEquals(1, solution(new int[]{1}));
    }

    @Test
    public void arrayOfTwoIsNotPermutation() {
        assertEquals(0, solution(new int[]{2}));
    }

    @Test
    public void arrayWithNegativeNumberIsNotPermutation() {
        assertEquals(0, solution(new int[]{1, 2, -1}));
    }

    @Test
    public void arrayWithZeroIsNotPermutation() {
        assertEquals(0, solution(new int[]{1, 2, 0}));
    }

    @Test
    public void sequenceWithGap() {
        assertEquals(0, solution(new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    public void sequenceWithDuplicates() {
        assertEquals(0, solution(new int[]{1, 2, 3, 4, 3, 3, 3}));
    }

    @Test
    public void exampleTest() {
        assertEquals(1, solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, solution(new int[]{4, 1, 3}));
    }
}
