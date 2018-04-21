package com.caoO.algorithms;

import com.caoO.std.StdDraw;

public class CInterval2D {
    private CInterval1D x;
    private CInterval1D y;

    public CInterval2D() {}

    public CInterval2D(CInterval1D x, CInterval1D y) {
        this.x = x;
        this.y = y;
    }

    public CInterval1D getX() {
        return x;
    }

    public void setX(CInterval1D x) {
        this.x = x;
    }

    public CInterval1D getY() {
        return y;
    }

    public void setY(CInterval1D y) {
        this.y = y;
    }

    /**
     * Draw this CInterval2D on the frame.
     */
    public void draw() {
        double halfWidth = this.getX().distance() / 2;
        double halfHeight = this.getY().distance() / 2;
        double centerX = this.getX().getBeg() + halfWidth;
        double centerY = this.getY().getBeg() + halfHeight;
        StdDraw.rectangle(centerX, centerY, halfWidth, halfHeight);
    }

    /**
     * Returns true if this CInterval2D intersects the specified CInterval2D.
     * @param cInterval2D the other CInterval2D
     * @return {@code true} if this CInterval2D intersects the argument CInterval2D;
     *         {@code false} otherwise
     */
    public boolean intersect(CInterval2D cInterval2D) {
        if (this.getX().intersect(cInterval2D.getX()) && this.getY().intersect(cInterval2D.getY()))
            return true;
        return false;
    }

    /**
     * Returns true if this CInterval2D contains the specified CInterval2D.
     *
     * @param  cInterval2D the other CInterval2D
     * @return {@code true} if this CInterval2D contains the argument CInterval2D;
     *         {@code false} otherwise
     */
    public boolean contains(CInterval2D cInterval2D) {
        if (this.getX().contains(cInterval2D.getX()) && this.getY().contains(cInterval2D.getY()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "CInterval2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
