package com.caoO.algorithms;

import java.math.BigInteger;

/**
 * These are some static algorithms about mathematics.
 *
 * @author caoO
 * @version 1.0.0
 */
public class CMath {

    private CMath() {
    }

    /**
     * Calculate the maximum common divisor of two nonnegative integers.
     *
     * @param p A nonnegative integer
     * @param q Another nonnegative integer
     * @return the maximum common divisor
     */
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    /**
     * Calculate the absolute value of an integer.
     *
     * @param i the integer
     * @return the absolute value
     */
    public static int abs(int i) {
        return (i < 0) ? -i : i;
    }

    /**
     * Calculate the absolute value of a double floating-point number.
     *
     * @param d the double floating-point number
     * @return the absolute value
     */
    public static double abs(double d) {
        return (d < 0) ? -d : d;
    }

    /**
     * Determine whether an integer is a prime.
     *
     * @param n the integer
     * @return result
     */
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Calculate the square root of a double floating-point number.
     *
     * @param d the double floating-point number
     * @return the square root
     */
    public static double sqrt(double d) {
        if (d < 0)
            return Double.NaN;
        double err = 1e-15;
        double t = d;
        while (CMath.abs(t - d / t) > err * t) {
            t = (d / t + t) / 2.0;
        }
        return t;
    }

    /**
     * Calculate the length of oblique edges by the length of two right edges of a right triangle
     *
     * @param a Length of one right edge
     * @param b Length of another right edge
     * @return Length of oblique edge
     */
    public static double hypotenuse(double a, double b) {
        return CMath.sqrt(a * a + b * b);
    }

    /**
     * Calculate harmonic series.
     *
     * @param n n
     * @return harmonic series
     */
    public static double harmonicSeries(int n) {
        double result = 0.0;
        for (int i = 1; i < n; i++) {
            result += 1.0 / i;
        }
        return result;
    }

    /**
     * Calculated logarithm.
     *
     * @param x true number
     * @param y base number
     * @return logarithm
     */
    public static double log(double x, double y) {
        return Math.log(x) / Math.log(y);
    }

    /**
     * Get an integer not greater than a logarithm
     *
     * @param x true number
     * @param y base number
     * @return the integer
     */
    public static int roundlog(double x, double y) {
        return (int) log(x, y);
    }

    /**
     * Statistical histogram.
     *
     * @param arr value array
     * @param m quantization level
     * @return histogram
     */
    public static int[] histogram(int[] arr, int m) {
        int[] result = new int[m];
        for (int i: arr) {
            if (i < m)
                result[i]++;
        }
        return result;
    }

    /**
     * Calculates the factorial of a specified integer
     *
     * @param n integer
     * @return factorial
     */
    public static BigInteger factorial(int n) {
        if (n == 1)
            return BigInteger.ONE;
        return factorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    /**
     * Compute binomial distribution probability.
     *
     * @param n Total number of experiments
     * @param k Total number of successful experiments
     * @param p Probability of success in a single trial
     * @return binomial distribution probability
     */
    public static double binomial(int n, int k, double p) {
        return c(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    // Calculate combination
    private static int c(int n, int k) {
        if (n - k == 1)
            return n;
        return c(n - 1, k) * n / (n - k);
    }
}
