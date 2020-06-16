package org.parctice.app.collected.matrix;

public class CellByCellRotateSquareMatrix {
    private int[][] matrix;

    public CellByCellRotateSquareMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] counterClockWise() {
        int squareSize = matrix.length;
        int cache, stepsPerCircle;

        int amountOfCircles = (int) Math.ceil((double) squareSize / 2);
        for (int row = 0; row < amountOfCircles; row++) {

            stepsPerCircle = squareSize - row - 1;
            for (int column = row; column < stepsPerCircle; column++) {

                // cache top right
                cache = matrix[row][column];

                // bottom right to top right
                matrix[row][column] = matrix[column][squareSize - 1 - row];

                // bottom left to bottom right
                matrix[column][squareSize - 1 - row] = matrix[squareSize - 1 - row][squareSize - 1 - column];

                // top left to bottom left
                matrix[squareSize - 1 - row][squareSize - 1 - column] = matrix[squareSize - 1 - column][row];

                // cache to top left
                matrix[squareSize - 1 - column][row] = cache;
            }
        }

        return matrix;
    }
}
