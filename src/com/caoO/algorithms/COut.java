package com.caoO.algorithms;

import java.io.PrintWriter;

public class COut {

    private static PrintWriter out = new PrintWriter(System.out);

    /**
     * Print a two-dimensional integer array.
     *
     * @param arr 2D array
     */
    public static void print2DArray(int[][] arr) {
        print2DArray(arr, ",");
    }

    /**
     * Print a two-dimensional integer array with the appointed separator.
     *
     * @param arr 2D array
     * @param separator separator to separate the elements.
     */
    public static void print2DArray(int[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1)
                    System.out.print(separator);
            }
            System.out.println();
        }
    }

    /**
     * Print a two-dimensional boolean array.
     *
     * @param arr 2D array
     */
    public static void print2DArray(boolean[][] arr) {
        print2DArray(arr, ",");
    }

    /**
     * Print a two-dimensional boolean array with the appointed separator.
     *
     * @param arr 2D array
     * @param separator separator to separate the elements.
     */
    public static void print2DArray(boolean[][] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j != arr[i].length - 1)
                    System.out.print(separator);
            }
            System.out.println();
        }
    }

    /**
     * Print an integer array.
     *
     * @param arr array
     */
    public static void printArray(int[] arr) { printArray(arr, ","); }

    /**
     * Print an integer array with the appointed separator.
     *
     * @param arr array
     * @param separator separator to separate the elements.
     */
    public static void printArray(int[] arr, String separator) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(separator);
        }
        System.out.println("]");
    }

    /**
     * Print an double array.
     *
     * @param arr array
     */
    public static void printArray(double[] arr) { printArray(arr, ","); }

    /**
     * Print an double array with the appointed separator.
     *
     * @param arr array
     * @param separator separator to separate the elements.
     */
    public static void printArray(double[] arr, String separator) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(separator);
        }
        System.out.println("]");
    }
}
