package org.parctice.app.codility;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Map<Integer, Integer> allNumbers = new HashMap<>();

        for (int numberNow : A) {
            if (!allNumbers.containsKey(numberNow)) {
                allNumbers.put(numberNow, 1);
            } else {
                allNumbers.put(numberNow, allNumbers.get(numberNow) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : allNumbers.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }

        // Task assumptions failed
        return -1;
    }


    public int solution_slow(int[] A) {

        int numberNow;
        boolean[] visited = new boolean[A.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < A.length; i++) {
            if (!visited[i]) {
                numberNow = A[i];

                if (numberFrequency_slow(A, visited, numberNow) % 2 != 0) {
                    return numberNow;
                }
            }
        }

        // Task assumptions failed
        return -1;
    }

    private int numberFrequency_slow(int[] a, boolean[] visited, int numberToSearch) {
        int frequency = 0;

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                if (a[i] == numberToSearch) {
                    frequency++;
                    visited[i] = true;
                }
            }
        }

        return frequency;
    }

    @Test
    public void exampleTest() {
        int expected = 7;
        int actual = solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        assertEquals(expected, actual);
    }

    @Test
    public void allSevens() {
        int expected = 7;
        int actual = solution(new int[]{7, 7, 7, 7, 7, 7, 7});
        assertEquals(expected, actual);
    }

    @Test
    public void onePair() {
        int expected = 1;
        int actual = solution(new int[]{0, 1, 0});
        assertEquals(expected, actual);
    }

    @Test
    public void multiplePairsThatRepeat() {
        int expected = 123;
        int actual = solution(new int[]{0, 0, 0, 0,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                123});
        assertEquals(expected, actual);
    }
}
