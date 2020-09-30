package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDiv {
    public int solution(int A, int B, int K) {
//        if (K > B) return 0; breaks the logic

        int additionForDivisibleA = A % K == 0 ? 1 : 0;

        return (int) (Math.floor(B / K) - Math.floor(A / K)) + additionForDivisibleA;
    }

    @Test
    public void noDivisibleNumber() {
        assertEquals(0, solution(3, 4, 10));
    }

    @Test
    public void smallDivisibleNumber() {
        assertEquals(4, solution(4, 16, 3));
    }

    @Test
    public void oneIsAlwaysDivisible() {
        assertEquals(13, solution(4, 16, 1));
    }

    @Test
    public void skipBigNumbers() {
        assertEquals(0, solution(4, 16, 100));
    }

    @Test
    public void exampleTest(){
        assertEquals(3, solution(6,11, 2));
    }

    @Test
    public void zeroA(){
        assertEquals(1, solution(0, 1, 11));
    }
}
