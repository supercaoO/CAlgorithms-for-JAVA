package com.caoO.algorithms;

import java.awt.geom.Point2D;
import java.util.List;

public class CPoints {
    private CPoints() {}

    /**
     * Calculate the minimum distance in some points.
     * @param points points
     * @return the minimum distance
     */
    public static double minDist(List<Point2D> points) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.size() - 1; i++) {
            Point2D p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point2D p2 = points.get(j);
                if (!(CMath.abs(p1.getX() - p2.getX()) > minDist || CMath.abs(p1.getY() - p2.getY()) > minDist)) {
                    double dist = Point2D.distance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                    if (dist < minDist) {
                        minDist = dist;
                    }
                }
            }
        }
        return minDist;
    }
}
