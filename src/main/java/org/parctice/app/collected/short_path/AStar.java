package org.parctice.app.collected.short_path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStar {
    private WorldMap map;
    private Point start;
    private Point end;
    private boolean pathFound = false;

    private List<Point> openList;
    private List<Point> closedList;
    private List<Point> foundPath = new ArrayList<>();

    public AStar(WorldMap map) {
        this.map = map;
    }

    public void setStart(Point start) {
        this.start = start;
        map.markStart(start);
    }

    public void setEnd(Point end) {
        this.end = end;
        map.markEnd(end);
    }

    public List<Point> calculatePath() {
        map.printResult();
        if (start.equals(end)) {
            return new ArrayList<>();
        } else {
            return reallyCalculatePath();
        }
    }

    private List<Point> reallyCalculatePath() {
        prepareForCalculations();
        check4Directions();

        if (pathFound) {
            System.out.println(foundPath);
            return foundPath;
        } else {
            System.out.println("Path not found :(");
            return new ArrayList<>();
        }
    }

    private void prepareForCalculations() {
        int noMovesSoFar = 0;
        openList = new ArrayList<>();
        closedList = new ArrayList<>();

        Point properStart = Point.createPoint(
                start.x,
                start.y,
                noMovesSoFar,
                ManhattanDistance.between(start, end));

        openList.add(properStart);
    }

    private void check4Directions() {
        while (!openList.isEmpty() && !pathFound) {
            tryMoving4DirectionsFrom(openList.get(0));
            Collections.sort(openList);
            map.printResult();
        }
    }

    private void tryMoving4DirectionsFrom(Point point) {
        tryMovingUpFrom(point);
        tryMovingLeftFrom(point);
        tryMovingDownFrom(point);
        tryMovingRightFrom(point);
        addPointToClosedList(point);
    }

    private void tryMovingUpFrom(Point point) {
        tryMovingToDirection(point.x, point.y - 1, point);
    }

    private void tryMovingLeftFrom(Point point) {
        tryMovingToDirection(point.x - 1, point.y, point);
    }

    private void tryMovingDownFrom(Point point) {
        tryMovingToDirection(point.x, point.y + 1, point);
    }

    private void tryMovingRightFrom(Point point) {
        tryMovingToDirection(point.x + 1, point.y, point);
    }

    private void tryMovingToDirection(int nextX, int nextY, Point currentPoint) {
        if (!pathFound) {
            Point targetPoint = createTargetPoint(nextX, nextY, currentPoint);

            if (targetPoint.equals(end)) {
                pathEndsOn(currentPoint);
            } else if (map.canMoveTo(targetPoint)) {
                compareWithOpenList(targetPoint);
                compareWithClosedList(targetPoint);
            }
        }
    }

    private Point createTargetPoint(int nextX, int nextY, Point currentPoint) {
        int newMoved = currentPoint.moved + 1;
        int newEstimatedMovesLeft = ManhattanDistance.between(nextX, nextY, end.x, end.y);

        Point targetPoint = Point.createPoint(
                nextX,
                nextY,
                newMoved,
                newEstimatedMovesLeft);
        targetPoint.setPreviousPoint(currentPoint);

        return targetPoint;
    }

    private void pathEndsOn(Point point) {
        pathFound = true;
        updateFoundPathWith(point);
        map.printResult();
    }

    private void updateFoundPathWith(Point point) {
        foundPath.add(point);
        map.markPath(point);
        checkPreviousPoint(point);

    }

    private void checkPreviousPoint(Point point) {
        Point previousPoint = point.getPreviousPoint();
        if (previousPoint != null) {
            updateFoundPathWith(previousPoint);
        }
    }

    private void compareWithOpenList(Point point) {
        if (openList.contains(point)) {
            int indexOfSimilarPoint = openList.indexOf(point);
            Point previousPoint = openList.get(indexOfSimilarPoint);
            openList.remove(indexOfSimilarPoint);
            addPointWithShorterPathToOpenList(point, previousPoint);
        }
    }

    private void addPointWithShorterPathToOpenList(Point point, Point previousPoint) {
        openList.add(previousPoint.compareTo(point) <= 0 ? previousPoint : point);
    }

    private void compareWithClosedList(Point point) {
        if (closedList.contains(point)) {
            checkIfClosedPointHasShorterPath(point);
        } else {
            addPointToOpenList(point);
        }
    }

    private void checkIfClosedPointHasShorterPath(Point point) {
        int indexOfSimilarPoint = closedList.indexOf(point);
        Point previousPoint = closedList.get(indexOfSimilarPoint);
        checkIfPointHasBetterPathThanPreviousPoint(point, previousPoint);
    }

    private void checkIfPointHasBetterPathThanPreviousPoint(Point point, Point previousPoint) {
        if (previousPoint.compareTo(point) > 0) {
            closedList.remove(previousPoint);
            addPointToOpenList(point);
        }
    }

    private void addPointToOpenList(Point point) {
        openList.add(point);
        map.markOpen(point);
    }

    private void addPointToClosedList(Point point) {
        openList.remove(point);
        closedList.add(point);
        map.markClosed(point);
    }
}
