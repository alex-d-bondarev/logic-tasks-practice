package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountBiggestBinaryGap {

    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int maxGap = 0;
        int currentGap = 0;
        boolean binaryGapStarted = false;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                if(!binaryGapStarted)
                    binaryGapStarted = true;

                if (currentGap > 0) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                }
            }

            if (binaryGapStarted && c == '0')
                currentGap++;

        }

        return maxGap;
    }

    @Test
    public void noGapForForSmallNumbers() {
        assertEquals(0, solution(0));
        assertEquals(0, solution(1));
        assertEquals(0, solution(2));
        assertEquals(0, solution(3));
        assertEquals(0, solution(4));
    }

    @Test
    public void fiveHasGapOf1() {
        assertEquals(1, solution(5));
    }

    @Test
    public void sixHasTrailingZerosAndNoGap() {
        assertEquals(0, solution(6));
    }

    @Test
    public void trailingZerosAndGapOf2() {
        assertEquals(2, solution(328));
    }
}
