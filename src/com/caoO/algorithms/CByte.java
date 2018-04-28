package com.caoO.algorithms;

public class CByte {
    private CByte() {}

    /**
     * Convert decimal byte to binary string of 8 bits
     * @param b decimal byte
     * @return binary string
     */
    public static String toBinaryString(byte b) {
        String binaryString = Integer.toBinaryString(b);
        int length = binaryString.length();
        if (length > 8) {
            return binaryString.substring(0,1) + binaryString.substring(length - 7, length);
        } else {
            for (int i = 0; i < 8 - length; i++) {
                binaryString = "0" + binaryString;
            }
        }
        return binaryString;
    }
}
