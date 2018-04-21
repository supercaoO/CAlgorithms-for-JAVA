package com.caoO.algorithms;

import com.caoO.std.StdDraw;
import com.caoO.std.StdRandom;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class VisualCounter {
    /// the number of operation
    private int operateNum;
    /// the maximum counting value
    private int maxCnt;
    /// the exiting points
    private LinkedList<Point2D> point2DS = new LinkedList<Point2D>();

    public VisualCounter() {}

    public VisualCounter(int operateNum, int maxCnt) {
        this.operateNum = operateNum;
        this.maxCnt = maxCnt;
    }

    /**
     * Visually add a point.
     */
    public void inc() {
        Point2D point = new Point2D.Double(StdRandom.uniform(), StdRandom.uniform());
        StdDraw.point(point);
        point2DS.add(point);
    }

    /**
     * Visually remove a point.
     */
    public void dec() {
        Point2D point = point2DS.poll();
        StdDraw.setPenColor(255, 255, 255);
        StdDraw.filledCircle(point.getX(), point.getY(), 0.002 * 512 * 0.002);
        StdDraw.setPenColor();
    }
}
