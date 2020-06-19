package org.parctice.app.collected.short_path;

public class ManhattanDistance {

    public static int between(Point from, Point to){
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }

    public static int between(int fromX, int fromY, int toX, int toY){
        return Math.abs(fromX - toX) + Math.abs(fromY - toY);
    }
}
