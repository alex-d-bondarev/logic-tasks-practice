package org.parctice.app.collected.short_path;

import org.parctice.app.helpers.Print2DArray;

/*
 * Map is a 2D int array, where 0 means can move and 1 means obstacle.
 * Positions start as 0,0 coordinates representing top left corner
 * */
public class WorldMap {
    private int[][] map;
    private String[][] result;

    public WorldMap(int[][] map) {
        this.map = map;
        initResult();
    }

    private void initResult() {
        int rowLength = map.length;
        int columnLength = getLongestColumn();
        result = new String[rowLength][columnLength];
        copyMapToResult();
    }

    private int getLongestColumn() {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            max = Math.max(map[i].length, max);
        }
        return max;
    }

    private void copyMapToResult() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                result[x][y] = map[x][y] == 0 ? " " : "X";
            }
        }
    }

    public boolean canMoveTo(Point point) {
        int x = point.x;
        int y = point.y;
        return xIsInMap(x) &&
                yIsInMap(x, y) &&
                !isObstacle(x, y);
    }

    private boolean xIsInMap(int x) {
        return x >= 0 && map.length > x;
    }

    private boolean yIsInMap(int x, int y) {
        return y >= 0 && map[x].length > y;
    }

    public boolean isObstacle(int x, int y) {
        if (x < 0 || y < 0) {
            throw new OutOfBounds();
        }
        try {
            return map[x][y] == 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OutOfBounds("x=" + x + ",y=" + y);
        }
    }

    public int getColumnLength() {
        return map[0].length;
    }

    public void printResult() {
        System.out.println("Empty stands for unvisited");
        System.out.println("X stands for obstacle");
        System.out.println("O stands for potential path");
        System.out.println("S stands for start");
        System.out.println("E stands for end");
        System.out.println("P stands for calculated path");
        System.out.println("Up is from right to left :)");
        new Print2DArray(System.out).print(result);
    }

    public void markStart(Point start) {
        markPointWith(start, "S");
    }

    private void markPointWith(Point point, String mark){
        result[point.x][point.y] = mark;
    }

    public void markEnd(Point end) {
        markPointWith(end, "E");
    }

    public void markPath(Point point) {
        if (pointIsNot(point, "S")) {
            markPointWith(point, "P");
        }
    }

    private boolean pointIsNot(Point point, String mark){
        return !result[point.x][point.y].equals(mark);
    }

    public void markOpen(Point point) {
        markPointWith(point, "O");
    }

    public void markClosed(Point point) {
        if (pointIsNot(point, "S") && pointIsNot(point, "P")) {
            markPointWith(point, "C");
        }
    }

    public static class OutOfBounds extends RuntimeException {
        public OutOfBounds() {
            super();
        }

        public OutOfBounds(String message) {
            super(message);
        }
    }
}
