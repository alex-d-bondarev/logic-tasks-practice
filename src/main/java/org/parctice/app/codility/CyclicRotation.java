package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if (A.length < 2 || arrayOfSameNumbers(A))
            return A;

        while (K > 0) {
            rotate(A);
            K--;
        }

        return A;
    }

    private boolean arrayOfSameNumbers(int[] a) {
        int num = a[0];

        for (int i : a) {
            if (i != num)
                return false;
        }

        return true;
    }

    private void rotate(int[] a) {
        int lastElement = a[a.length - 1];
        System.arraycopy(a, 0, a, 1, a.length - 1);
        a[0] = lastElement;
    }

    @Test
    public void emptyArrayShouldNotFail() {
        int[] emptyArray = new int[0];
        assertArrayEquals(emptyArray, solution(emptyArray, 0));
        assertArrayEquals(emptyArray, solution(emptyArray, 999));
    }

    @Test
    public void oneElementArrayDoesNotChange() {
        int[] oneElement = new int[]{1};
        assertArrayEquals(oneElement, solution(oneElement, 0));
        assertArrayEquals(oneElement, solution(oneElement, 999));
    }

    @Test
    public void noNeedToRateArrayOfZeros() {
        int[] oneElement = new int[]{0, 0, 0};
        assertArrayEquals(oneElement, solution(oneElement, 0));
        assertArrayEquals(oneElement, solution(oneElement, 999));
    }

    @Test
    public void noNeedToRateArrayOfSameNumbers() {
        int[] oneElement = new int[]{1, 1, 1};
        assertArrayEquals(oneElement, solution(oneElement, 0));
        assertArrayEquals(oneElement, solution(oneElement, 999));
    }

    @Test
    public void rotateSmallArray() {
        assertArrayEquals(new int[]{0, 1}, solution(new int[]{0, 1}, 0));
        assertArrayEquals(new int[]{1, 0}, solution(new int[]{0, 1}, 1));
        assertArrayEquals(new int[]{0, 1}, solution(new int[]{0, 1}, 2));
    }

    @Test
    public void rotateArrayOfThree() {
        assertArrayEquals(new int[]{0, 1, 2}, solution(new int[]{0, 1, 2}, 0));
        assertArrayEquals(new int[]{2, 0, 1}, solution(new int[]{0, 1, 2}, 1));
        assertArrayEquals(new int[]{1, 2, 0}, solution(new int[]{0, 1, 2}, 2));
        assertArrayEquals(new int[]{0, 1, 2}, solution(new int[]{0, 1, 2}, 3));
    }
}
