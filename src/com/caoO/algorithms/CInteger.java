package com.caoO.algorithms;

public class CInteger {
    private CInteger() {}

    /**
     * Convert decimal integer to binary string
     *
     * @param n decimal integer
     * @return binary string
     */
    public static String toBinaryString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n % 2);
        n /= 2;
        while (n != 0) {
            stringBuilder.insert(0, n % 2);
            n = n / 2;
        }
        return stringBuilder.toString();
    }
}
