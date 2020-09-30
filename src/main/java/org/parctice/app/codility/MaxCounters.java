package org.parctice.app.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int allTimeMax = 0;
        int previousMax = 0;

        for (int X : A) {
            if (X <= N) {
                counters[X-1] = Math.max(counters[X-1], previousMax);
                counters[X-1]++;
                allTimeMax = Math.max(counters[X-1], allTimeMax);
            } else {
                previousMax = allTimeMax;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], previousMax);
        }

        return counters;
    }


    private int[] counters_initial;
    private int maxCounter_initial;

    public int[] solution_initial(int N, int[] A) {
        counters_initial = new int[N];
        maxCounter_initial = 0;

        for (int X : A) {
            if (X <= N) {
                increase_initial(X);
            } else {
                maxCounter_initial();
            }
        }

        return counters_initial;
    }

    private void increase_initial(int X) {
        counters_initial[X-1] += 1;
        maxCounter_initial = Math.max(maxCounter_initial, counters_initial[X-1]);
    }

    private void maxCounter_initial() {
        Arrays.fill(counters_initial, maxCounter_initial);
    }

    @Test
    public void zeroCounters() {
        assertArrayEquals(new int[]{0, 0}, solution(2, new int[]{10}));
    }

    @Test
    public void increaseFirstTwice() {
        assertArrayEquals(new int[]{2, 0}, solution(2, new int[]{1, 1}));
    }

    @Test
    public void maxCounterAfterIncrease() {
        assertArrayEquals(new int[]{1, 1}, solution(2, new int[]{1, 3}));
    }

    @Test
    public void exampleTest() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }
}
