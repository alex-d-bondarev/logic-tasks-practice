package org.parctice.app.collected.matrix;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RotateSquareMatrixTest {

    @Test
    public void oneOverOneMatrixDoesNotChange() {
        int[][] initialMatrix = {{11}};
        assertRotationIsExpected(initialMatrix, initialMatrix);
    }

    @Test
    public void test2By2Matrix() {
        int[][] initialMatrix = {
                {11, 12},
                {21, 22}
        };
        int[][] expectedRotatedMatrix = {
                {12, 22},
                {11, 21}
        };
        assertRotationIsExpected(initialMatrix, expectedRotatedMatrix);
    }

    @Test
    public void test3By3Matrix(){
        int[][] initialMatrix = {
                {11, 12, 13},
                {21, 22, 23},
                {31, 32, 33}
        };
        int[][] expectedRotatedMatrix = {
                {13, 23, 33},
                {12, 22, 32},
                {11, 21, 31}
        };
        assertRotationIsExpected(initialMatrix, expectedRotatedMatrix);
    }

    @Test
    public void test4By4Matrix(){
        int[][] initialMatrix = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}
        };
        int[][] expectedRotatedMatrix = {
                {14, 24, 34, 44},
                {13, 23, 33, 43},
                {12, 22, 32, 42},
                {11, 21, 31, 41}
        };
        assertRotationIsExpected(initialMatrix, expectedRotatedMatrix);
    }

    private void assertRotationIsExpected(int[][] initialMatrix, int[][] expectedRotatedMatrix) {
        CellByCellRotateSquareMatrix rotator = new CellByCellRotateSquareMatrix(initialMatrix);
        int[][] rotatedMatrix = rotator.counterClockWise();
        assertTrue(Arrays.deepEquals(expectedRotatedMatrix, rotatedMatrix));
    }
}
