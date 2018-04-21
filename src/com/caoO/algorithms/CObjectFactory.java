package com.caoO.algorithms;

import com.caoO.std.StdRandom;

public class CObjectFactory {
    private CObjectFactory() {}

    /**
     * Construct a random integer array with specified length and numerical range.
     * Range is [min, max].
     *
     * @param length the length of array
     * @param min minimum value
     * @param max maximum value
     * @return the random array
     */
    public static int[] randomArray(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(min, max + 1);
        }
        return arr;
    }

    /**
     * Construct a random double array with specified length and numerical range.
     * Range is [min, max).
     *
     * @param length the length of array
     * @param min minimum value
     * @param max maximum value
     * @return the random array
     */
    public static double[] randomArray(int length, double min, double max) {
        double[] arr = new double[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(min, max);
        }
        return arr;
    }

    /**
     * Construct a random CInterval1D array with specified length and numerical range.
     * Range is [min, max].
     * @param length the length of array
     * @param min minimum beginning
     * @param max maximum end
     * @return the random array
     */
    public static CInterval1D[] randomInterval1D(int length, int min, int max) {
        CInterval1D[] arr = new CInterval1D[length];
        for (int i = 0; i < arr.length; i++) {
            double[] doubles = randomTwoSortedDouble(min, max);
            CInterval1D cInterval1D = new CInterval1D(doubles[0], doubles[1]);
            arr[i] = cInterval1D;
        }
        return arr;
    }

    /**
     * Construct a random CInterval1D array with specified length and numerical range.
     * Range is [min, max).
     * @param length the length of array
     * @param min minimum beginning
     * @param max maximum end
     * @return the random array
     */
    public static CInterval1D[] randomInterval1D(int length, double min, double max) {
        CInterval1D[] arr = new CInterval1D[length];
        for (int i = 0; i < arr.length; i++) {
            double[] doubles = randomTwoSortedDouble(min, max);
            CInterval1D cInterval1D = new CInterval1D(doubles[0], doubles[1]);
            arr[i] = cInterval1D;
        }
        return arr;
    }

    /**
     * Construct a random CInterval2D array with specified length and numerical range.
     * Range for X-direction is [minX, maxX), Range for Y-direction is [minY, maxY),.
     * @param length the length of array
     * @param minX minimum beginning on X-direction
     * @param maxX maximum end on X-direction
     * @param minY minimum beginning on Y-direction
     * @param maxY maximum end on Y-direction
     * @return the random array
     */
    public static CInterval2D[] randomInterval2D(int length, double minX, double maxX, double minY, double maxY) {
        CInterval2D[] arr = new CInterval2D[length];
        for (int i = 0; i < arr.length; i++) {
            double[] doubles = randomTwoSortedDouble(minX, maxX);
            CInterval1D cInterval2DX = new CInterval1D(doubles[0], doubles[1]);
            doubles = randomTwoSortedDouble(minY, maxY);
            CInterval1D cInterval2DY = new CInterval1D(doubles[0], doubles[1]);
            arr[i] = new CInterval2D(cInterval2DX, cInterval2DY);
        }
        return arr;
    }

    /// Random acquisition of two ordered double numbers
    private static double[] randomTwoSortedDouble(double min, double max) {
        double[] arr = new double[2];
        double r1 = StdRandom.uniform(min, max);
        double r2 = StdRandom.uniform(min, max);
        if (r1 > r2) {
            double temp = r2;
            r2 = r1;
            r1 = temp;
        }
        arr[0] = r1;
        arr[1] = r2;
        return arr;
    }
}
