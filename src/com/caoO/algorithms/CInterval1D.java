package com.caoO.algorithms;

import java.util.Objects;

public class CInterval1D {
    private double beg;
    private double end;

    public CInterval1D() {};

    public CInterval1D(double beg, double end) {
        this.beg = beg;
        this.end = end;
    }

    public double getEnd() {
        return end;
    }

    public double getBeg() {
        return beg;
    }

    public void setBeg(double beg) {
        this.beg = beg;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    /**
     * Returns true if this interval intersects the specified interval.
     *
     * @param  cInterval1D the other interval
     * @return {@code true} if this interval intersects the argument interval;
     *         {@code false} otherwise
     */
    public boolean intersect(CInterval1D cInterval1D) {
        if (this.end < cInterval1D.getBeg())
            return false;
        if (this.beg > cInterval1D.getEnd())
            return false;
        return true;
    }

    /**
     * Returns true if this interval contains the specified interval.
     * @param cInterval1D the other interval
     * @return {@code true} if this interval contains the argument interval;
     *         {@code false} otherwise
     */
    public boolean contains(CInterval1D cInterval1D) {
        if (this.getBeg() < cInterval1D.getBeg() && this.getEnd() > cInterval1D.getEnd())
            return true;
        return false;
    }

    /**
     * Calculate the distance of CInterval1D
     * @return the distance
     */
    public double distance() {
        return this.getEnd() - this.getBeg();
    }

    @Override
    public String toString() {
        return "CInterval1D{" +
                "beg=" + beg +
                ", end=" + end +
                '}';
    }

    /**
     * Returns true if this interval equals to the specified interval.
     * @param o the specified interval
     * @return {@code true} if this interval equals to the argument interval;
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CInterval1D that = (CInterval1D) o;
        return Double.compare(that.beg, beg) == 0 &&
                Double.compare(that.end, end) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(beg, end);
    }
}
