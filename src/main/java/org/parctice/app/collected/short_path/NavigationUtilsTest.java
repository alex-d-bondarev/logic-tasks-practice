package org.parctice.app.collected.short_path;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NavigationUtilsTest {

    private WorldMap testMap;

    @Before
    public void canCreateMap() {
        int[][] map = {
                {0, 0},
                {0, 1}
        };
        testMap = new WorldMap(map);
    }

    @Test
    public void canDetectObstacle() {
        assertTrue(testMap.isObstacle(1, 1));
    }

    @Test
    public void canDetectMovable() {
        assertFalse(testMap.isObstacle(0, 0));
    }

    @Test(expected = WorldMap.OutOfBounds.class)
    public void topLeftOutOfMap() {
        testMap.isObstacle(-1, -1);
    }

    @Test(expected = WorldMap.OutOfBounds.class)
    public void bottomOutOfMap() {
        testMap.isObstacle(testMap.getColumnLength() + 1, 0);
    }

    @Test
    public void canStoreLocation() {
        Point.createPoint(0, 1);
    }

    @Test
    public void distanceBetweenSamePointsIsZero() {
        Point point = Point.createPoint(0, 1);
        assertEquals(0, ManhattanDistance.between(point, point));
    }

    @Test
    public void distanceInSameRow() {
        assertEquals(1, ManhattanDistance.between(0, 0, 1, 0));
    }

    @Test
    public void distanceInSameColumn() {
        assertEquals(1, ManhattanDistance.between(0, 0, 0, 1));
    }

    @Test
    public void noDiagonalMovesBut1RowAnd1Column() {
        assertEquals(2, ManhattanDistance.between(0, 0, 1, 1));
    }
}
