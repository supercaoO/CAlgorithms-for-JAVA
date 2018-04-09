package com.caoO.algorithms;

import com.caoO.exception.EmptyMatrixException;
import com.caoO.exception.EmptyVectorException;
import com.caoO.exception.MismatchingMatrixException;
import com.caoO.exception.NotMatrixException;

public class CMatrix {

    private CMatrix() {}

    /**
     * addition of two vectors.
     *
     * @param x one vector
     * @param y another vector
     * @return result vector
     */
    public static int[] add(int[] x, int[] y) {
        matrixNotNull(x, y);
        int m1 = x.length;
        int m2 = y.length;
        vectorNotEmpty(m1, m2);
        matrixNotMismatching(m1, m2);
        int[] add = new int[m1];
        for (int i = 0; i < m1; i++) {
            add[i] = x[i] + y[i];
        }
        return add;
    }

    /**
     * Dot multiplication of two vectors.
     *
     * @param x one vector
     * @param y another vector
     * @return resykt of dot multiplication
     */
    public static int dot(int[] x, int[] y) {
        matrixNotNull(x, y);
        vectorNotEmpty(x.length, y.length);
        matrixNotMismatching(x.length, y.length);
        int dot = 0;
        for (int i = 0; i < x.length; i++) {
            dot += x[i] * y[i];
        }
        return dot;
    }

    /**
     * Dot multiplication of two vectors.
     *
     * @param x one vector
     * @param y another vector
     * @return resykt of dot multiplication
     */
    public static double dot(double[] x, double[] y) {
        matrixNotNull(x, y);
        vectorNotEmpty(x.length, y.length);
        matrixNotMismatching(x.length, y.length);
        double dot = 0;
        for (int i = 0; i < x.length; i++) {
            dot += x[i] * y[i];
        }
        return dot;
    }

    /**
     * Multiplication of two int matrices.
     *
     * @param arr1 a int matrix
     * @param arr2 another int matrix
     * @return the result int matrix
     */
    public static int[][] mult(int[][] arr1, int[][] arr2) {
        matrixNotNull(arr1, arr2);
        isMatrixAndNotEmpty(arr1, arr2);
        int m1 = arr1.length;
        int n1 = arr1[0].length;
        int m2 = arr2.length;
        int n2 = arr2[0].length;
        matrixNotMismatching(n1, m2);
        int[][] arr = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < m2; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }

    /**
     * Multiplication of two double matrices.
     *
     * @param arr1 a double matrix
     * @param arr2 another double matrix
     * @return the result double matrix
     */
    public static double[][] mult(double[][] arr1, double[][] arr2) {
        matrixNotNull(arr1, arr2);
        isMatrixAndNotEmpty(arr1, arr2);
        int m1 = arr1.length;
        int n1 = arr1[0].length;
        int m2 = arr2.length;
        int n2 = arr2[0].length;
        matrixNotMismatching(n1, m2);
        double[][] arr = new double[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < m2; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }

    /**
     * Multiplication of a double matrix and a double vector.
     *
     * @param arr matrix
     * @param x vector
     * @return result vector
     */
    public static double[] mult(double[][] arr, double[] x) {
        matrixNotNull(arr, x);
        isMatrixAndNotEmpty(arr);
        int m1 = arr.length;
        int n1 = arr[0].length;
        int m2 = x.length;
        vectorNotEmpty(m2);
        matrixNotMismatching(n1, m2);
        double[] mult = new double[m1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                mult[i] += arr[i][j] * x[j];
            }
        }
        return mult;
    }

    /**
     * Multiplication of a double vector and a double matrix.
     *
     * @param x vector
     * @param arr matrix
     * @return result vector
     */
    public static double[] mult(double[] x, double[][] arr) {
        matrixNotNull(x, arr);
        isMatrixAndNotEmpty(arr);
        int n1 = x.length;
        int m2 = arr.length;
        int n2 = arr[0].length;
        vectorNotEmpty(n1);
        matrixNotMismatching(n1, m2);
        double[] mult = new double[n2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                mult[i] += x[j] * arr[j][i];
            }
        }
        return mult;
    }

    /**
     * Transpose the original 2-D Matrix to generate a new 2-D Matrix.
     *
     * @param arr original 2-D Matrix
     * @return new transposed 2-D Matrix
     */
    public static double[][] transpose(double[][] arr) {
        return transpose(arr, false);
    }

    /**
     * Original address transpose or New address transpose to the original Two-Dimensional Matrix according to the parameters.
     *
     * @param arr original 2-D Matrix
     * @param b true for Original address transpose, false for New address transpose
     * @return new transposed 2-D Matrix.
     */
    public static double[][] transpose(double[][] arr, boolean b) {
        matrixNotNull(arr);
        isMatrixAndNotEmpty(arr);
        int m = arr.length;
        int n = arr[0].length;
        if (b) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    double temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
            return arr;
        } else {
            double[][] result = new double[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[j][i] = arr[i][j];
                }
            }
            return result;
        }
    }

    /**
     * Transpose the original 2-D Matrix to generate a new 2-D Matrix.
     *
     * @param arr original 2-D Matrix
     * @return new transposed 2-D Matrix
     */
    public static int[][] transpose(int[][] arr) {
        return transpose(arr, false);
    }

    /**
     * Original address transpose or New address transpose to the original Two-Dimensional Matrix according to the parameters.
     *
     * @param arr original 2-D Matrix
     * @param b true for Original address transpose, false for New address transpose
     * @return new transposed 2-D Matrix.
     */
    public static int[][] transpose(int[][] arr, boolean b) {
        matrixNotNull(arr);
        isMatrixAndNotEmpty(arr);
        int m = arr.length;
        int n = arr[0].length;
        if (b) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
            return arr;
        } else {
            int[][] result = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[j][i] = arr[i][j];
                }
            }
            return result;
        }
    }

    // throw an IllegalArgumentException if obj is null
    // (obj is any type of array)
    private static void matrixNotNull(Object... obj) {
        for (Object o : obj) {
            if (o == null)
                throw new IllegalArgumentException("matrix is null");
        }
    }

    // Check if the matrices are really matrix and not empty.
    private static void isMatrixAndNotEmpty(int[][]... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 0)
                throw new EmptyMatrixException();
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].length == 0)
                    throw new EmptyMatrixException();
                if (j < arr[i].length - 1 && arr[i][j].length != arr[i][j + 1].length)
                    throw new NotMatrixException();
            }
        }
    }

    // Check if the matrices are really matrix and not empty.
    private static void isMatrixAndNotEmpty(double[][]... arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 0)
                throw new EmptyMatrixException();
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].length == 0)
                    throw new EmptyMatrixException();
                if (j < arr[i].length - 1 && arr[i][j].length != arr[i][j + 1].length)
                    throw new NotMatrixException();
            }
        }
    }

    // Check if the vectors are not empty.
    private static void vectorNotEmpty(int... lens) {
        for (int len : lens) {
            if (len == 0)
                throw new EmptyVectorException();
        }
    }

    // Check if the two matrices are mismatch the number of rows.
    private static void matrixNotMismatching(int n, int m) {
        if (n != m)
            throw new MismatchingMatrixException();
    }
}
