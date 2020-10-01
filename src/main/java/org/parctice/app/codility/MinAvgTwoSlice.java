package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        float minAvgGlobal = Float.MAX_VALUE;
        float averageOf2, averageOf3;
        int minAvgPosition = 0;

        for (int i = 0; i < A.length - 2; i++) {
            averageOf2 = (float) (A[i] + A[i + 1]) / 2;
            averageOf3 = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;

            if (averageOf2 < minAvgGlobal) {
                minAvgGlobal = averageOf2;
                minAvgPosition = i;
            }

            if (averageOf3 < minAvgGlobal) {
                minAvgGlobal = averageOf3;
                minAvgPosition = i;
            }
        }

        float lastAveragePair = (float) (A[A.length - 2] + A[A.length - 1]) / 2;
        if (lastAveragePair < minAvgGlobal) {
            return A.length - 2;
        }

        return minAvgPosition;
    }

    @Test
    public void exampleTest() {
        assertEquals(1, solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

}
