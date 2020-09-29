package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if (X == Y || X > Y)
            return 0;

        return (int) Math.ceil((double) (Y - X) / D);
    }

    @Test
    public void alreadyInPlace() {
        assertEquals(0, solution(1, 1, 10));
    }

    @Test
    public void startIsFurterThenTarget() {
        assertEquals(0, solution(10, 1, 10));
    }

    @Test
    public void oneJumpIsEnough() {
        assertEquals(1, solution(1, 10, 9));
        assertEquals(1, solution(1, 10, 10));
        assertEquals(1, solution(1, 100, 100));
        assertEquals(1, solution(1, 1000, 1000));
    }

    @Test
    public void twoJumpsToGo() {
        assertEquals(2, solution(1, 10, 5));
        assertEquals(2, solution(1, 100, 50));
        assertEquals(2, solution(1, 1000, 500));
    }

    @Test
    public void tenJumpsToGo() {
        assertEquals(10, solution(1, 11, 1));
        assertEquals(10, solution(1, 101, 10));
        assertEquals(10, solution(1, 1001, 100));
    }

    @Test
    public void oneSmallExtraStepIsNeeded() {
        assertEquals(2, solution(1, 11, 9));
        assertEquals(2, solution(1, 101, 99));
        assertEquals(2, solution(1, 1001, 999));
    }

    @Test
    public void exampleTest() {
        assertEquals(3, solution(10, 85, 30));
    }
}
