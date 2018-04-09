package com.caoO.test;

import com.caoO.algorithms.*;
import com.caoO.std.StdDraw;
import com.caoO.std.StdOut;
import com.caoO.std.StdRandom;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class Improve1_1 {

    @Test
    public void i26() {
        int a = 3, b = 2, c = 1, t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        StdOut.println(a + "-" + b + "-" + c);
    }

    @Test
    public void i27() {
        long beg = System.currentTimeMillis();
        double p = i27_binomial(80, 5, 0.5);
        long end = System.currentTimeMillis();
        StdOut.println(end - beg + "ms");
        StdOut.println(p);
        beg = System.currentTimeMillis();
        double pImp = CMath.binomial(80, 5, 0.5);
        end = System.currentTimeMillis();
        StdOut.println(end - beg + "ms");
        StdOut.println(pImp);
    }

    public static double i27_binomial(int n, int k, double p) {
        if (n == 0 && k == 0)
            return 1.0;
        if (n < 0 || k < 0)
            return 0;
        return (1 - p) * i27_binomial(n - 1, k, p) + p * i27_binomial(n - 1, k -1, p);
    }

    @Test
    public void i28() {
        // Leave out
    }

    @Test
    public void i29() {
        int[] arr = CObjectFactory.randomArray(20, 0, 20);
        Arrays.sort(arr);
        COut.printArray(arr);
        int num = CArrays.ltCount(14, arr);
        System.out.println(num);
        int[] arr02 = CObjectFactory.randomArray(20, 0, 10);
        Arrays.sort(arr02);
        COut.printArray(arr02);
        int count = CArrays.count(4, arr02);
        System.out.println(count);
    }

    @Test
    public void i30() {
        boolean[][] booleans = i30_construct(4, 5);
        COut.print2DArray(booleans);
    }

    public static boolean[][] i30_construct(int m, int n) {
        boolean[][] booleans = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (CMath.gcd(i, j) == 1)
                    booleans[i][j] = true;
                else
                    booleans[i][j] =false;
            }
        }
        return booleans;
    }

    @Test
    public void i31() {
        i31_draw(6, 0.5);
    }

    public static void i31_draw(int n, double p) {
        int len = 600;
        StdDraw.setCanvasSize(len, len);
        StdDraw.setXscale(0, len);
        StdDraw.setYscale(0, len);

        double r = 200;
        Point2D center = new Point2D.Double(len / 2, len / 2);
        StdDraw.circle(center.getX(), center.getY(), r);

        double radian = Math.PI * 2 / n;
        Point2D[] point2DS = new Point2D[n];
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < n; i++) {
            point2DS[i] = new Point2D.Double(center.getX() + r * Math.cos(radian * i), center.getY() + r * Math.sin(radian * i));
            StdDraw.point(point2DS[i].getX(), point2DS[i].getY());
        }
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (StdRandom.bernoulli(p))
                    StdDraw.line(point2DS[i].getX(), point2DS[i].getY(), point2DS[j].getX(), point2DS[j].getY());
            }
        }

        StdDraw.pause(1000000);
    }

    @Test
    public void i32() {
        int n = 100;
        double l = 0.0, r = 5.0;
        double[] arr = CObjectFactory.randomArray(n * 10, l, r);
        i32_histogram(n, l, r, arr);
    }

    public static void i32_histogram(int n, double l, double r, double[] arr) {
        double[] block = new double[n];
        for (int i = 0; i < n; i++) {
            block[i] = (r - l) * i / n;
        }
        double[] h = new double[n];
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] < l || arr[i] > r)) {
                int index = CArrays.ltCount(arr[i], block) - 1;
                h[index]++;
            }
        }
        for (int i = 0; i < n; i++) {
            double x = 1.0 * i / n;
            double y = (double) h[i] / n;
            double rw = 0.5 / n;
            double rh = (double) h[i] / n;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
        StdDraw.pause(1000000);
    }

    @Test
    public void i33() {
        // See CMatrix.
    }

    @Test
    public void i34() {
        // Remove duplication, sort and get the value the index(k - 1) points to.
    }
}
