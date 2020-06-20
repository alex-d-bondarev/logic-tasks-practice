package org.parctice.app.collected.short_path;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertEquals;

public class ShortPathTest {

    private int[][] map;
    private AStar aStar;

    @Before
    public void setup() {
        map = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        aStar = new AStar(new WorldMap(map));
    }

    @Test
    public void beginningIsTheEndIn1x1Map() {
        map = new int[][]{{0}};
        WorldMap gameWorldMap = new WorldMap(map);
        AStar aStar = new AStar(gameWorldMap);
        Point single = Point.createPoint(0, 0);

        aStar.setStart(single);
        aStar.setEnd(single);

        List<Point> path = aStar.calculatePath();

        assertThat(path, is(empty()));
    }

    @Test
    public void canMoveUp() {
        Point start = Point.createPoint(1, 2);
        Point end = Point.createPoint(1, 1);
        List<Point> expectedPath = Collections.singletonList(Point.createPoint(1, 2, 0, 1));

        assertPathIsFound(start, end, expectedPath);
    }

    @Test
    public void canMoveLeft() {
        Point start = Point.createPoint(1, 1);
        Point end = Point.createPoint(0, 1);
        List<Point> expectedPath = Collections.singletonList(Point.createPoint(1, 1, 0, 1));

        assertPathIsFound(start, end, expectedPath);
    }

    @Test
    public void canMoveDown() {
        Point start = Point.createPoint(1, 1);
        Point end = Point.createPoint(1, 2);
        List<Point> expectedPath = Collections.singletonList(Point.createPoint(1, 1, 0, 1));

        assertPathIsFound(start, end, expectedPath);
    }

    @Test
    public void canMoveRight() {
        Point start = Point.createPoint(1, 1);
        Point end = Point.createPoint(2, 1);
        List<Point> expectedPath = Collections.singletonList(Point.createPoint(1, 1, 0, 1));

        assertPathIsFound(start, end, expectedPath);
    }

    @Test
    public void canMoveUp2Steps() {
        Point start = Point.createPoint(1, 2);
        Point end = Point.createPoint(1, 0);
        List<Point> expectedPath = Arrays.asList(
                Point.createPoint(1, 1, 1, 1),
                Point.createPoint(1, 2, 0, 2)
        );

        assertPathIsFound(start, end, expectedPath);
    }

    @Test
    public void canMoveDiagonally() {
        Point start = Point.createPoint(1, 1);
        Point end = Point.createPoint(2, 2);
        int expectedSteps = 2;

        aStar.setStart(start);
        aStar.setEnd(end);

        int stepsTaken = aStar.calculatePath().size();
        assertEquals(expectedSteps, stepsTaken);
    }

    @Test
    public void canHandleComplexMap() {
        Point start = Point.createPoint(7, 4);
        Point end = Point.createPoint(1, 0);
        int expectedSteps = 18;

        map = new int[][]{
                {0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        aStar = new AStar(new WorldMap(map));
        aStar.setStart(start);
        aStar.setEnd(end);

        int stepsTaken = aStar.calculatePath().size();
        assertEquals(expectedSteps, stepsTaken);
    }

    private void assertPathIsFound(Point start, Point end, List<Point> expectedPath) {
        aStar.setStart(start);
        aStar.setEnd(end);

        List<Point> actualPath = aStar.calculatePath();
        assertEquals(expectedPath, actualPath);
    }
}
