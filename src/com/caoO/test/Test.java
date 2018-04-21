package com.caoO.test;

import com.caoO.algorithms.CArrays;
import com.caoO.algorithms.CMath;
import com.caoO.algorithms.CMatrix;
import com.caoO.algorithms.COut;

public class Test {
    private Test() {}

    @org.junit.Test
    public void test01() {
        int i = CMath.abs(-1);
        System.out.println(i);
    }

    @org.junit.Test
    public void test02() {
        double d = CMath.sqrt(0.01);
        System.out.println(d);
    }

    @org.junit.Test
    public void test03() {
        double d = java.lang.Math.pow(10, 15);
        System.out.println(d);
    }

    @org.junit.Test
    public void test04() {
        double d = CMath.hypotenuse(3, 4);
        System.out.println(d);
    }

    @org.junit.Test
    public void test05() {
        String[] str = { null, "s", null, "b", "c" };
        String s = CArrays.max(str);
        System.out.println(s);
    }

    @org.junit.Test
    public void test06() {
        double[] str = { 2, Double.NaN, 1 };
        double d = CArrays.max(str);
        System.out.println(d);
    }

    @org.junit.Test
    public void test07() {
        int[][] arr1 = { {1, 2, 3}, {1, 2, 3} };
        int[][] arr2 = { {1, 2}, {1, 2}, {1, 2} };
        int[][] arr = CMatrix.mult(arr1, arr2);
        COut.print2DArray(arr);
    }

    @org.junit.Test
    public void test08() {
        double[][] arr1 = { {1, 2, 3}, {1, 2, 3} };
        double[] arr2 = { 1, 2, 3 };
        double[] arr = CMatrix.mult(arr1, arr2);
        COut.printArray(arr);
    }

    @org.junit.Test
    public void test09() {
        double[][] arr1 = { {1, 2}, {1, 2}, {1, 2} };
        double[] arr2 = { 1, 2, 3 };
        double[] arr = CMatrix.mult(arr2, arr1);
        COut.printArray(arr);
    }

    @org.junit.Test
    public void test10() {
        int[][] arr1 = { {1, 2}, {1, 2}, {1, 2} };
        int[][] arr = CMatrix.transpose(arr1);
        COut.print2DArray(arr);
    }
}
