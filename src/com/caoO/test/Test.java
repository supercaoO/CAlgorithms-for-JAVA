package com.caoO.test;

import com.caoO.algorithms.*;
import com.caoO.utils.compress.Rar;
import com.caoO.utils.compress.SevenZ;
import com.caoO.utils.compress.Zip;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
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

    @org.junit.Test
    public void test11() {
        System.out.println((364 + 365 * 3) % 7);
    }

    @org.junit.Test
    public void test12() {
        System.out.println(742 % 7);
    }

    @org.junit.Test
    public void test13() {
        System.out.println(((364 + 365 * 3) * 4 + 364 + 365 + 1) % 7);
    }

    @org.junit.Test
    public void test14() {
        System.out.println(((366 + 365 * 3) * 4 + 366 + 365 + 1) % 7);
    }

    @org.junit.Test
    public void test5() {
        System.out.println(-11 % 7);
    }

    @org.junit.Test
    public void test6() {
        SevenZ.compress("B","E:/A.doc","E:/");
        Zip.compress("C", "E:/B.7z", "E:/");
        Rar.compress("D", "E:/B.7z", "E:/");
        SevenZ.compress("E", "E:/B.7z", "E:/");
    }

    public static void main(String[] args) {
        //加载dom树
        Document doc = null;
        try {
            doc = new SAXReader().read("E:/IDEAworkspace/CAlgorithms for JAVA/srcdata.xml");
            //获取节点
            //List<Element> list = doc.selectNodes("/web-app/servlet/servlet-name");
            //Element ele = list.get(0);
            Element ele = (Element) doc.selectSingleNode("//compress-cmd/rar/url");
            System.out.println(ele.getText());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test7() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(CInteger.toBinaryString(-1));
    }
}
