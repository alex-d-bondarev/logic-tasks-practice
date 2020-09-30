package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GenomicRangeQuery {

    private int[][] genomePrefixSums;
    private int from;
    private int to;

    public int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        genomePrefixSums = new int[3][S.length() + 1];
        calculateGenomePrefixSums(S);

        for (int i = 0; i < P.length; i++) {
            from = P[i] + 1;
            to = Q[i] + 1;

            if (rangeHasAtLeastOneAGenome()) {
                result[i] = 1;
            } else if (rangeHasAtLeastOneCGenome()) {
                result[i] = 2;
            } else if (rangeHasAtLeastOneGGenome()) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }

    private void calculateGenomePrefixSums(String s) {
        int a, c, g;
        char gNow;

        for (int i = 0; i < s.length(); i++) {
            gNow = s.charAt(i);

            a = 0;
            c = 0;
            g = 0;

            if (gNow == 'A') a = 1;
            if (gNow == 'C') c = 1;
            if (gNow == 'G') g = 1;

            genomePrefixSums[0][i + 1] = genomePrefixSums[0][i] + a;
            genomePrefixSums[1][i + 1] = genomePrefixSums[1][i] + c;
            genomePrefixSums[2][i + 1] = genomePrefixSums[2][i] + g;
        }
    }

    private boolean rangeHasAtLeastOneAGenome() {
        return rangeHasAtLeastOneNthGenome(0);
    }

    private boolean rangeHasAtLeastOneCGenome() {
        return rangeHasAtLeastOneNthGenome(1);
    }

    private boolean rangeHasAtLeastOneGGenome() {
        return rangeHasAtLeastOneNthGenome(2);
    }

    private boolean rangeHasAtLeastOneNthGenome(int n) {
        return genomePrefixSums[n][to] - genomePrefixSums[n][from - 1] > 0;
    }

    @Test
    public void onlyAGenome() {
        assertArrayEquals(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                solution("AAAAAAA", getTestP(), getTestQ()));
    }

    @Test
    public void onlyCGenome() {
        assertArrayEquals(
                new int[]{2, 2, 2, 2, 2, 2, 2, 2},
                solution("CCCCCCC", getTestP(), getTestQ()));
    }

    @Test
    public void onlyGGenome() {
        assertArrayEquals(
                new int[]{3, 3, 3, 3, 3, 3, 3, 3},
                solution("GGGGGGG", getTestP(), getTestQ()));
    }

    @Test
    public void onlyTGenome() {
        assertArrayEquals(
                new int[]{4, 4, 4, 4, 4, 4, 4, 4},
                solution("TTTTTTT", getTestP(), getTestQ()));
    }

    @Test
    public void exampleTest() {
        assertArrayEquals(
                new int[]{2, 4, 1},
                solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

    private int[] getTestP() {
        return new int[]{0, 1, 2, 3, 4, 5, 3, 0};
    }

    private int[] getTestQ() {
        return new int[]{1, 2, 3, 4, 5, 6, 6, 6};
    }
}
