package com.caoO.test;

import com.caoO.algorithms.*;
import com.caoO.std.StdDraw;
import com.caoO.std.StdRandom;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Exercises1_2 {

    @Test
    public void e1() {
        double min = minDist(1500);
        System.out.println(min);
        StdDraw.pause(100000);
    }

    private static double minDist(int n) {
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Point2D p = new Point2D.Double(StdRandom.uniform(), StdRandom.uniform());
            StdDraw.point(p.getX(), p.getY());
            points.add(p);
        }
        return CPoints.minDist(points);
    }

    @Test
    public void e2() {
        CInterval1D[] cInterval1DS = CObjectFactory.randomInterval1D(50, 0.0, 10.0);
        for (int i = 0; i < cInterval1DS.length - 1; i++) {
            for (int j = i + 1; j < cInterval1DS.length; j++) {
                if (cInterval1DS[i].intersect(cInterval1DS[j]))
                    System.out.println(cInterval1DS[i] + "<---->" + cInterval1DS[j]);
            }
        }
    }

    @Test
    public void e3() {
        CInterval2D[] cInterval2DS = CObjectFactory.randomInterval2D(10, 0.0, 1.0, 0.0, 1.0);
        int intersect = 0;
        int contains = 0;
        for (int i = 0; i < cInterval2DS.length; i++) {
            cInterval2DS[i].draw();
            for (int j = i + 1; j < cInterval2DS.length; j++) {
                if (cInterval2DS[i].intersect(cInterval2DS[j]))
                    intersect++;
                if (cInterval2DS[i].contains(cInterval2DS[j]) || cInterval2DS[j].contains(cInterval2DS[i]))
                    contains++;
            }
        }
        System.out.println("The number of intersecting is " + intersect + ", and the number of containing is " + contains);
        StdDraw.pause(100000);
    }

    @Test
    public void e4() {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
    }

    @Test
    public void e5() {
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        System.out.println(s);
    }

    @Test
    public void e6() {
        boolean b = CString.isCircularRotation("ACTGACG", "TGACGAC");
        System.out.println(b);
        b = CString.isCircularRotation("TGACGAC", "ACTGACG");
        System.out.println(b);
    }

    @Test
    public void e7() {
        String s = "hello world";
        System.out.println(mystery(s));;
    }

    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return mystery(a) + mystery(b);
    }

    @Test
    public void e8() {
        int[] a = new int[10000000];
        int[] b = new int[10000000];
        int[] temp = new int[10000000];
        temp = a;
        a = b;
        b = temp;
    }

    @Test
    public void e9() {
        /// leave out
    }

    @Test
    public void e10() {
        VisualCounter vc = new VisualCounter();
        for (int i = 0; i < 2000; i++) {
            vc.inc();
        }
        for (int i = 0; i < 1990; i++) {
            vc.dec();
        }
        StdDraw.pause(100000);
    }

    @Test
    public void e11() {
        SmartDate date = new SmartDate(1996, 2, 29);
    }

    @Test
    public void e12() {
        SmartDate date = new SmartDate(1999, 12, 31);
        System.out.println(date.dayOfTheWeek());
    }
}
