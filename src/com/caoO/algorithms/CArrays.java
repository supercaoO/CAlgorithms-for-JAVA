package com.caoO.algorithms;

import com.caoO.exception.EmptyMatrixException;
import com.caoO.exception.MismatchingMatrixException;
import com.caoO.exception.NotMatrixException;
import com.caoO.std.StdRandom;

import java.util.Arrays;

/**
 * These are some static algorithms for arrays
 *
 * @author caoO
 * @version 1.0.0
 */
public class CArrays {
    private CArrays() {}

    /**
     * Find the max object from the object array.
     *
     * @param arr object array
     * @param <T> object type
     * @return the max object of array
     */
    public static <T extends Comparable> T max(T[] arr) {
        validateNotNull(arr);
        T max = null;
        int beg = 0;
        while (beg < arr.length) {
            if (arr[beg] != null) {
                max = arr[beg];
                break;
            }
            beg++;
        }
        for (int i = beg; i < arr.length; i++) {
            if (arr[i] != null && arr[i].compareTo(max) == 1)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max byte from the byte array.
     *
     * @param arr byte array
     * @return the max byte of array
     */
    public static byte max(byte[] arr) {
        validateNotNull(arr);
        byte max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max short from the short array.
     *
     * @param arr short array
     * @return the max short of array
     */
    public static short max(short[] arr) {
        validateNotNull(arr);
        short max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max int from the int array.
     *
     * @param arr int array
     * @return the max int of array
     */
    public static int max(int[] arr) {
        validateNotNull(arr);
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max long from the long array.
     *
     * @param arr long array
     * @return the max long of array
     */
    public static long max(long[] arr) {
        validateNotNull(arr);
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max float from the float array.
     *
     * @param arr float array
     * @return the max float of array
     */
    public static float max(float[] arr) {
        validateNotNull(arr);
        float max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Float.isNaN(arr[i]))
                return Float.NaN;
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max double from the double array.
     *
     * @param arr double array
     * @return the max double of array
     */
    public static double max(double[] arr) {
        validateNotNull(arr);
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Double.isNaN(arr[i]))
                return Double.NaN;
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the max char from the char array.
     *
     * @param arr char array
     * @return the max char of array
     */
    public static char max(char[] arr) {
        validateNotNull(arr);
        char max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Find the min object from the object array.
     *
     * @param arr object array
     * @param <T> object type
     * @return the min object of array
     */
    public static <T extends Comparable> T min(T[] arr) {
        validateNotNull(arr);
        T min = null;
        int beg = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                min = arr[i];
                beg = i;
                break;
            }
        }
        for (int i = beg; i < arr.length; i++) {
            if (arr[i] != null && arr[i].compareTo(min) == -1)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min byte from the byte array.
     *
     * @param arr byte array
     * @return the min byte of array
     */
    public static byte min(byte[] arr) {
        validateNotNull(arr);
        byte min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min short from the short array.
     *
     * @param arr short array
     * @return the min short of array
     */
    public static short min(short[] arr) {
        validateNotNull(arr);
        short min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min int from the int array.
     *
     * @param arr int array
     * @return the min int of array
     */
    public static int min(int[] arr) {
        validateNotNull(arr);
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min long from the long array.
     *
     * @param arr long array
     * @return the min long of array
     */
    public static long min(long[] arr) {
        validateNotNull(arr);
        long min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min float from the float array.
     *
     * @param arr float array
     * @return the min float of array
     */
    public static float min(float[] arr) {
        validateNotNull(arr);
        float min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Float.isNaN(arr[i]))
                return Float.NaN;
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min double from the double array.
     *
     * @param arr double array
     * @return the min double of array
     */
    public static double min(double[] arr) {
        validateNotNull(arr);
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Double.isNaN(arr[i]))
                return Double.NaN;
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Find the min char from the char array.
     *
     * @param arr char array
     * @return the min char of array
     */
    public static char min(char[] arr) {
        validateNotNull(arr);
        char min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Calculate the sum of the int array.
     *
     * @param arr int array
     * @return the sum of array
     */
    public static int sum(int[] arr) {
        validateNotNull(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    /**
     * Calculate the sum of the double array.
     *
     * @param arr double array
     * @return the sum of array
     */
    public static double sum(double[] arr) {
        validateNotNull(arr);
        double sum = 0.0;
        for (double d : arr) {
            sum += d;
        }
        return sum;
    }

    /**
     * Calculate the average of the int array.
     *
     * @param arr int array
     * @return the average of array
     */
    public static double avg(int[] arr) {
        validateNotNull(arr);
        if (arr.length == 0)
            return Double.NaN;
        return (double) sum(arr) / arr.length;
    }

    /**
     * Calculate the average of the double array.
     *
     * @param arr double array
     * @return the average of array
     */
    public static double avg(double[] arr) {
        validateNotNull(arr);
        if (arr.length == 0)
            return Double.NaN;
        return sum(arr) / arr.length;
    }

    /**
     * Reverse the object array.
     *
     * @param arr object array
     * @param <T> object type
     * @return the reversed object array
     */
    public static <T> T[] reverse(T[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        T temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the int array.
     *
     * @param arr int array
     * @return the reversed int array
     */
    public static boolean[] reverse(boolean[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        boolean temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the byte array.
     *
     * @param arr byte array
     * @return the reversed byte array
     */
    public static byte[] reverse(byte[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        byte temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the short array.
     *
     * @param arr short array
     * @return the reversed short array
     */
    public static short[] reverse(short[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        short temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the int array.
     *
     * @param arr int array
     * @return the reversed int array
     */
    public static int[] reverse(int[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        int temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the long array.
     *
     * @param arr long array
     * @return the reversed long array
     */
    public static long[] reverse(long[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        long temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the double array.
     *
     * @param arr double array
     * @return the reversed double array
     */
    public static double[] reverse(double[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        double temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Reverse the char array.
     *
     * @param arr char array
     * @return the reversed char array
     */
    public static char[] reverse(char[] arr) {
        validateNotNull(arr);
        int len = arr.length;
        char temp;
        for (int i = 0; i < len / 2; i++) {
            temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
        return arr;
    }

    /**
     * Returns the sample variance in the specified array.
     *
     * @param  arr the array
     * @return the sample variance in the array
     */
    public static double var(double[] arr) {
        validateNotNull(arr);
        if (arr.length == 0) return Double.NaN;
        double avg = avg(arr);
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] - avg) * (arr[i] - avg);
        }
        return sum / (arr.length - 1);
    }

    /**
     * Returns the sample variance in the specified array.
     *
     * @param  arr the array
     * @return the sample variance in the array
     */
    public static double var(int[] arr) {
        validateNotNull(arr);
        if (arr.length == 0) return Double.NaN;
        double avg = avg(arr);
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += (arr[i] - avg) * (arr[i] - avg);
        }
        return sum / (arr.length - 1);
    }

    /**
     * Returns the sample standard deviation in the specified array.
     *
     * @param  arr the array
     * @return the sample standard deviation in the array {@code a[]};
     *         {@code Double.NaN} if no such value
     */
    public static double stddev(double[] arr) {
        validateNotNull(arr);
        return CMath.sqrt(var(arr));
    }

    /**
     * Returns the sample standard deviation in the specified array.
     *
     * @param  arr the array
     * @return the sample standard deviation in the array {@code a[]};
     *         {@code Double.NaN} if no such value
     */
    public static double stddev(int[] arr) {
        validateNotNull(arr);
        return CMath.sqrt(var(arr));
    }

    /**
     * Count the number of elements in an array that are less than a particular element.
     * And no need to sort advance.
     *
     * @param key particular element
     * @param arr array
     * @return the number of elements that are smaller
     */
    public static int ltCount(int key, int[] arr) {
        return ltCount(key, arr, 0, arr.length - 1);
    }

    /**
     * Count the number of elements in the array index range that are less than a particular element.
     * And no need to sort advance.
     *
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int ltCount(int key, int[] arr, int lo, int hi) {
        if (lo > hi || lo < 0 || hi >= arr.length)
            throw new IndexOutOfBoundsException();
        int[] newArr = Arrays.copyOfRange(arr, lo, hi);
        newArr[newArr.length - 1] = key;
        Arrays.sort(newArr);
        return ltCount_(key, newArr, lo, hi);
    }

    /**
     * Count the number of elements in an array that are greater than a particular element.
     * And no need to sort advance.
     *
     * @param key particular element
     * @param arr array
     * @return the number
     */
    public static int gtCount(int key, int[] arr) {
        return gtCount(key, arr, 0, arr.length - 1);
    }

    /**
     * Count the number of elements in the array index range that are greater than a particular element.
     * And no need to sort advance.
     *
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int gtCount(int key, int[] arr, int lo, int hi) {
        if (lo > hi || lo < 0 || hi >= arr.length)
            throw new IndexOutOfBoundsException();
        int ltKeyPlusOne = ltCount(key + 1, arr, lo, hi);
        return arr.length - ltKeyPlusOne;
    }

    /**
     * Count the number of specific element in an array.
     * And no need to sort advance.
     *
     * @param key specific element
     * @param arr array
     * @return the number
     */
    public static int count(int key, int[] arr) {
        return count(key, arr, 0, arr.length - 1);
    }

    /**
     * Count the number of elements in a specified element within the range of an array to be indexed.
     * And no need to sort advance.
     *
     * @param key specified element
     * @param arr array
     * @param lo begin index
     * @param hi end index
     * @return the number
     */
    public static int count(int key, int[] arr, int lo, int hi) {
        if (lo > hi || lo < 0 || hi >= arr.length)
            throw new IndexOutOfBoundsException();
        int ltKey = ltCount(key, arr, lo, hi);
        int ltKeyPlusOne = ltCount(key + 1, arr, lo, hi);
        return ltKeyPlusOne - ltKey;
    }

    // Count the number of elements in the array index range that are less than a particular element.
    private static int ltCount_(int key, int[] arr, int lo, int hi) {
        int index = CSearch.binarySearch(key, arr, lo, hi);
        if (index == -1) {
            return hi + 1;
        } else {
            return ltCount_(key, arr, lo, index - 1);
        }
    }

    /**
     * Count the number of elements in an array that are less than a particular element.
     * And no need to sort advance.
     *
     * @param key particular element
     * @param arr array
     * @return the number of elements that are smaller
     */
    public static int ltCount(double key, double[] arr) {
        return ltCount(key, arr, 0, arr.length - 1);
    }

    /**
     * Count the number of elements in the array index range that are less than a particular element.
     * And no need to sort advance.
     *
     * @param key
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int ltCount(double key, double[] arr, int lo, int hi) {
        if (lo > hi || lo < 0 || hi >= arr.length)
            throw new IndexOutOfBoundsException();
        double[] newArr = Arrays.copyOfRange(arr, lo, hi);
        newArr[newArr.length - 1] = key;
        Arrays.sort(newArr);
        return ltCount_(key, newArr, lo, hi);
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  arr the array to shuffle
     * @throws IllegalArgumentException if {@code a} is {@code null}
     */
    public static void shuffle(double[] arr) {
        validateNotNull(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(n-i);     // between i and n-1
            double temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
    }

    /**
     * Rearranges the elements of the specified array in uniformly random order.
     *
     * @param  a the array to shuffle
     * @throws IllegalArgumentException if {@code a} is {@code null}
     */
    public static void shuffle(int[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + StdRandom.uniform(n-i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    // Count the number of elements in the array index range that are less than a particular element.
    private static int ltCount_(double key, double[] arr, int lo, int hi) {
        int index = CSearch.binarySearch(key, arr, lo, hi);
        if (index == -1) {
            return hi + 1;
        } else {
            return ltCount_(key, arr, lo, index - 1);
        }
    }

    // throw an IllegalArgumentException if obj is null
    // (obj is any type of array)
    private static void validateNotNull(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("array is null");
    }
}
