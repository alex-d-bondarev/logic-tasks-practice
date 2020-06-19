package org.parctice.app.collected.short_path;

public class Point implements Comparable<Point>{
    public final int x, y, moved, estimatedMovesLeft;
    private Point previousPoint;

    private Point (int x, int y, int moved, int estimatedMovesLeft){
        this.x = x;
        this.y = y;
        this.moved = moved; // g
        this.estimatedMovesLeft = estimatedMovesLeft; //h
    }

    public static Point createPoint(int x, int y){
        return new Point(x, y, 0, 0);
    }

    public static Point createPoint(int x, int y, int moved, int estimatedMovesLeft){
        return new Point(x, y, moved, estimatedMovesLeft);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point otherPoint = (Point) o;
        return this.x == otherPoint.x &&
                this.y == otherPoint.y;
    }

    @Override
    public int compareTo(Point o) {
        return (this.moved + this.estimatedMovesLeft) - (o.moved + o.estimatedMovesLeft);
    }

    @Override
    public String toString() {
        return String.format("x=%d:y=%d:moved=%d:estimated=%d;", x, y, moved, estimatedMovesLeft);
    }

    @Override
    public int hashCode() {
        return x+y;
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }

    public void setPreviousPoint(Point previousPoint) {
        this.previousPoint = previousPoint;
    }
}
