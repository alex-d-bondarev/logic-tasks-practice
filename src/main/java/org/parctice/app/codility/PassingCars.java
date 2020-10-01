package org.parctice.app.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassingCars {
    public int solution(int[] A) {
        int drivingEast = 0;
        int eastDrivers = 0;
        int pairs = 0;

        for (int car : A) {
            if (car == drivingEast) {
                eastDrivers++;
            } else {
                pairs += eastDrivers;
            }

            if (pairs > 1_000_000_000)
                return -1;
        }

        return pairs;
    }

    @Test
    public void exampleTest() {
        assertEquals(5, solution(new int[]{0, 1, 0, 1, 1}));
    }
}
