package com.caoO.algorithms;

public class CSearch {

    /**
     * Use binary search method to find specific element from an array.
     *
     * @param key specific element
     * @param arr array
     * @return if found, return the index of specific element, if not, return -1
     */
    public static int binarySearch(int key, int[] arr) {
        return binarySearch(key, arr, 0, arr.length - 1);
    }

    /**
     * Using binary search method to find specific element from a specific range of indexes in an array
     *
     * @param key specific element
     * @param arr array
     * @param lo begin index
     * @param hi end index
     * @return if found, return the index of specific element, if not, return -1
     */
    public static int binarySearch(int key, int[] arr, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return binarySearch(key, arr, lo, mid - 1);
        if (key > arr[mid])
            return binarySearch(key, arr, mid + 1, hi);
        else
            return mid;
    }

    /**
     * Use binary search method to find specific element from an array.
     *
     * @param key specific element
     * @param arr array
     * @return if found, return the index of specific element, if not, return -1
     */
    public static int binarySearch(double key, double[] arr) {
        return binarySearch(key, arr, 0, arr.length - 1);
    }

    /**
     * Using binary search method to find specific element from a specific range of indexes in an array
     *
     * @param key specific element
     * @param arr array
     * @param lo begin index
     * @param hi end index
     * @return if found, return the index of specific element, if not, return -1
     */
    public static int binarySearch(double key, double[] arr, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return binarySearch(key, arr, lo, mid - 1);
        if (key > arr[mid])
            return binarySearch(key, arr, mid + 1, hi);
        else
            return mid;
    }
}
