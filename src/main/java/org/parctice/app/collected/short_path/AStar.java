package org.parctice.app.collected.short_path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AStar {
    private WorldMap map;
    private Point start, end;
    private boolean pathFound = false;

    private List<Point> openList, closedList, foundPath = new ArrayList<>();


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

        while (!openList.isEmpty() && !pathFound) {
            tryMovingAllDirectionsFrom(openList.get(0));
            Collections.sort(openList);
            map.printResult();
        }

        if(pathFound){
            System.out.println(foundPath);
            return foundPath;
        } else {
            System.out.println("Path not found :(");
            return new ArrayList<>();
        }
    }

    private void tryMovingAllDirectionsFrom(Point point) {
        tryMovingUpFrom(point);
        markClosed(point);
    }

    private void tryMovingUpFrom(Point point) {
        if (!pathFound) {
            int newY = point.y - 1;
            int newMoved = point.moved + 1;
            int newEstimatedMovesLeft = ManhattanDistance.between(point.x, newY, end.x, end.y);

            Point upPoint = Point.createPoint(
                    point.x,
                    newY,
                    newMoved,
                    newEstimatedMovesLeft);
            upPoint.setPreviousPoint(point);

            if (upPoint.equals(end)) {
                pathEndsOn(point);
            } else if (map.canMoveTo(upPoint)) {
                checkOpenListAgainst(upPoint);
                checkClosedListAgainst(upPoint);
            }
        }
    }

    private void checkOpenListAgainst(Point point) {
        if (openList.contains(point)) {
            int indexOfSimilarPoint = openList.indexOf(point);
            Point previousPoint = openList.get(indexOfSimilarPoint);
            openList.remove(indexOfSimilarPoint);
            openList.add(
                    previousPoint.compareTo(point) <= 0 ? previousPoint : point
            );
        } else {
            openList.add(point);
        }
        map.markPotentialPath(point);
    }

    private void checkClosedListAgainst(Point point) {
        if (closedList.contains(point)) {
            int indexOfSimilarPoint = closedList.indexOf(point);
            Point previousPoint = closedList.get(indexOfSimilarPoint);
            if (previousPoint.compareTo(point) > 0) {
                closedList.remove(previousPoint);
            } else {
                map.markDeadEnd(point);
            }
        }
    }

    private void pathEndsOn(Point point) {
        pathFound = true;
        map.markPathTo(point);
        updateFoundPathWith(point);
    }

    private void updateFoundPathWith(Point point) {
        foundPath.add(point);
        Point previousPoint = point.getPreviousPoint();
        if (previousPoint != null) {
            updateFoundPathWith(previousPoint);
        }
    }

    private void markClosed(Point point) {
        openList.remove(point);
        closedList.add(point);
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
}
