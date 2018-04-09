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

}
