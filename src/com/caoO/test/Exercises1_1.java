package com.caoO.test;

import com.caoO.algorithms.CMath;
import com.caoO.algorithms.CMatrix;
import com.caoO.algorithms.COut;
import com.caoO.std.StdOut;
import com.caoO.std.StdRandom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercises1_1 {

    @Test
    public void e1() {
        System.out.println((0 + 15) / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
    }

    @Test
    public void e2() {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 > 4);
        System.out.println(1 + 2 + "3");
    }

    @Test
    public void e3() {
        e3_method(new String[]{"1", "1", "1"});
    }

    private static void e3_method(String[] args) {
        boolean b = true;
        for (int i = 0; i < args.length - 1; i++) {
            if (!args[i].equals(args[i + 1])) {
                b = false;
                break;
            }
        }
        if (b)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }

    @Test
    public void e4() {
        int a = 1, b = 2, c;
        //wrong
        //if (a > b) then c = 0;
        if (a > b) { c = 0; }
        if (a > b) c = 0;
        //wrong
        //if (a > b) c = 0 else b = 0;
    }

    @Test
    public void e5() {
        e5_method(0.2, 1.5);
    }

    private static void e5_method(double x, double y) {
        if (x > 0 && x < 1 && y > 0 && y < 1)
            System.out.println(true);
        else
            System.out.println(false);
    }

    @Test
    public void e6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @Test
    public void e7() {
        // a
        double t = 9.0;
        while (CMath.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
        // b
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
        // c
        sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }

    @Test
    public void e8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    @Test
    public void e9() {
        String s = e9_method(10);
        System.out.println(s);
    }

    private static String e9_method(int n) {
        //return CInteger.toBinaryString(n);

        String s = "";
        for (int i = n; i > 0; i /= 2) {
            s = (i % 2) + s;
        }
        return s;
    }

    @Test
    public void e10() {
        /*int[] a;
        for (int i = 0; i < 10; i++) {
            a[i] = i * i;
        }*/
    }

    @Test
    public void e11() {
        boolean[][] booleans = { { true, false, false },
                                 { false, true },
                                 { true, false, true }
                                };
        e11_method(booleans);
    }

    // This typesetting is valid for a two-dimensional array of up to 10 rows and 10 columns.
    private static void e11_method(boolean[][] booleans) {
        int max = 0;
        for (boolean[] b: booleans) {
            if (b.length > max)
                max = b.length;
        }

        System.out.print("  ");
        for (int i = 0; i < max; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < booleans.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < booleans[i].length; j++) {
                System.out.print(booleans[i][j] ? "* " : "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void e12() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void e13() {
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        CMatrix.transpose(arr, true);
        COut.print2DArray(arr, "/");
    }

    @Test
    public void e14() {
        int n = CMath.roundlog(11, 10);
        System.out.println(n);
    }

    @Test
    public void e15() {
        int[] arr = { 1, 1, 1, 3, 3, 2, 4, 4, 6, 7, 6, 10 };
        int[] result = CMath.histogram(arr, 11);
        for (int i: result) {
            StdOut.println(i);
        }
    }

    @Test
    public void e16() {
        String s = e16_method(6);
        StdOut.println(s);
    }

    public static String e16_method(int n) {
        if (n <= 0)
            return "";
        return e16_method(n - 3) + n + e16_method(n - 2) + n;
    }

    @Test
    public void e17() {
        // Infinite recursion
        /*String s = e17_method(6);
        StdOut.println(s);*/
    }

    // Infinite recursion
    /*public static String e17_method(int n) {
        String s = e16_method(n - 3) + n + e16_method(n - 2) + n;
        if (n <= 0)
            return "";
        return s;
    }*/

    @Test
    public void e18() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int result = e18_method02(i, j);
                StdOut.println(i + "-" + j + "-" + result);
            }
        }
    }

    // Result is a * b
    public static int e18_method01(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return e18_method01(a + a, b / 2);
        return e18_method01(a + a, b / 2) + a;
    }

    // Result is a to b power
    public static int e18_method02(int a, int b) {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return e18_method02(a * a, b / 2);
        return e18_method02(a * a, b / 2) * a;
    }

    @Test
    public void e19() {
        for (int i = 0; i < 100; i++) {
            StdOut.println(i + "-" + e19_method(i));
        }
    }

    public static int e19_method(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return e19_method(n - 1) + e19_method(n - 2);
    }

    @Test
    public void e20() {
        double d = e20_method(3);
        StdOut.println(d);
    }

    public static double e20_method(int n) {
        return CMath.log(CMath.factorial(n).doubleValue(), Math.E);
    }

    @Test
    public void e21() {
        // See main(String[] args)
    }

    @Test
    public void e22() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = StdRandom.uniform(25);
        }
        int index = e22_method(22, arr, 0, arr.length - 1, 0);
        System.out.println(index);
        if (index != -1)
            System.out.println(arr[index]);
    }

    public static int e22_method(int key, int[] arr, int lo, int hi, int depth) {
        e22_method02(depth, "--");
        StdOut.println(lo + "," + hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return e22_method(key, arr, lo, mid - 1, depth + 1);
        if (key > arr[mid])
            return e22_method(key, arr, mid + 1, hi, depth + 1);
        else
            return mid;
    }

    public static void e22_method02(int depth, String separator) {
        for (int i = 0; i < depth; i++) {
            System.out.print(separator);
        }
    }

    @Test
    public void e23() {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = StdRandom.uniform(20);
            System.out.print(arr[i]);
            if (i < 19)
                System.out.print("-");
        }
        System.out.println();
        int[] whiteList ={ 1, 2, 3, 4, 5 };
        Arrays.sort(arr);
        e23_method(arr, whiteList, "+");
    }

    public static void e23_method(int[] arr, int[] whiteList, String operation) {
        if (operation == "+") {
            for (int i : whiteList) {
                if (-1 == e23_method02(i, arr, 0, arr.length - 1))
                    System.out.println(i);
            }
        } else if (operation == "-") {
            for (int i : whiteList) {
                if (-1 != e23_method02(i, arr, 0, arr.length - 1))
                    System.out.println(i);
            }
        }
    }

    public static int e23_method02(int key, int[] arr, int lo, int hi) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return e23_method02(key, arr, lo, mid - 1);
        if (key > arr[mid])
            return e23_method02(key, arr, mid + 1, hi);
        else
            return mid;
    }

    @Test
    public void e24() {
        int p = 1111111, q = 1234567;
        int result = e24_method(p, q, 0);
        System.out.println(result);
    }

    public static int e24_method(int p, int q, int depth) {
        e22_method02(depth, "--");
        System.out.println(p + "," + q);
        if (q == 0)
            return p;
        int r = p % q;
        return e24_method(q, r, depth + 1);
    }

    @Test
    public void e25() {
        // Leave out
    }

    public static void main(String[] args) {
        class Bean {
            private String name;
            private int a;
            private int b;
            private double c;
            public Bean() {}
            public Bean(String name, int a, int b, double c) {
                this.name = name;
                this.a = a;
                this.b = b;
                this.c = c;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public int getA() {
                return a;
            }
            public void setA(int a) {
                this.a = a;
            }
            public int getB() {
                return b;
            }
            public void setB(int b) {
                this.b = b;
            }
            public double getC() {
                return c;
            }
            public void setC(double c) {
                this.c = c;
            }
        }

        Scanner in = new Scanner(System.in);
        List<Bean> beans = new ArrayList<>();
        while (in.hasNext()) {
            String name = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            double c = (double) a / b;
            beans.add(new Bean(name, a, b, c));
        }
        beans.forEach(e->{
            StdOut.printf("%s %d %d %.3f\n", e.getName(), e.getA(), e.getB(), e.getC()); });
    }
}
