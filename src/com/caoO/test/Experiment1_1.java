package com.caoO.test;

import com.caoO.algorithms.*;
import com.caoO.std.StdRandom;
import com.sun.javafx.css.CssError;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Experiment1_1 {

    @Test
    public void e35() {
        int n = 100000;
        int[] dice1 = CObjectFactory.randomArray(n, 1, 6);
        int[] dice2 = CObjectFactory.randomArray(n, 1, 6);
        int[] sum = CMatrix.add(dice1, dice2);
        Map<Integer, Double> probability = CProbability.statistics(sum);
        probability.forEach((k, v)->{
            System.out.println(k + "-->" + v + "-->" + CProbability.dice2Sum(k));
        });
    }

    @Test
    public void e36() {
        e36_shuffle(10, 100);
    }

    public static void e36_test() {
        int m = 15;
        int[] arr = new int[m];
        for (int j = 0; j < m; j++) {
            arr[j] = j;
        }
        COut.printArray(arr);
        CArrays.shuffle(arr);
        COut.printArray(arr);
    }

    public static void e36_shuffle(int m, int n) {
        int[] arr = new int[m];
        int[][] result = new int[m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j] = j;
            }
            CArrays.shuffle(arr);
            for (int j = 0; j < m; j++) {
                result[arr[j]][j]++;
            }
        }
        COut.print2DArray(result);
    }

    @Test
    public void e37() {
        // Leave out
    }

    @Test
    public void e38() {
        int[] arr = CObjectFactory.randomArray((int) 1e8, 0, 10000);
        Arrays.sort(arr);
        long begin = System.currentTimeMillis();
        bruteForceSearch(StdRandom.uniform(10000), arr);
        long end = System.currentTimeMillis();
        System.out.println("BruteForceSearch:" + (end - begin) + "ms");
        begin = System.currentTimeMillis();
        CSearch.binarySearch(StdRandom.uniform(10000), arr);
        end = System.currentTimeMillis();
        System.out.println("binarySearch:" + (end - begin) + "ms");
    }

    public static int bruteForceSearch(int key, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    @Test
    public void e39() {
        int t = 10;
        for (int i = 3; i < 7; i++) {
            int[] arr1 = CObjectFactory.randomArray((int) Math.pow(10, i), (int) 1e5, (int) 1e6);
            int[] arr2 = CObjectFactory.randomArray((int) Math.pow(10, i), (int) 1e5, (int) 1e6);
            Arrays.sort(arr1);
            for (int j = 0; j < t; j++) {
                Set<Integer> set = e39_intersection(arr1, arr2);
                set.forEach(e-> System.out.print(e + "/"));
            }
            System.out.println();
        }
    }

    public static Set<Integer> e39_intersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            int index = CSearch.binarySearch(arr2[i], arr1);
            if (index != -1)
                set.add(arr2[i]);
        }
        return set;
    }
}
