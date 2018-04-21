package com.caoO.algorithms;

public class CString {

    private CString() {}

    /**
     * Determines whether a string is a palindrome.
     *
     * @param s string
     * @return result
     */
    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    /**
     * Check if the elements in a string array are alphabetical.
     *
     * @param sArr string array
     * @return result
     */
    public static boolean isSorted(String[] sArr) {
        int len = sArr.length;
        for (int i = 0; i < len - 1; i++) {
            if (sArr[i].compareTo(sArr[i + 1]) > 0)
                return false;
        }
        return true;
    }

    /**
     * Return true if the two specified strings are circular rotation.
     * @param str1 one string
     * @param str2 another string
     * @return result
     */
    public static boolean isCircularRotation(String str1, String str2) {
        return (str1.length() == str2.length()) && (str1 + str1).indexOf(str2) > 0;
    }
}
