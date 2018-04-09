package com.caoO.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CProbability {

    private CProbability() {}

    public static double[] dice2Sum() {
        int size = 6;
        double[] dist = new double[2 * size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= size * 2; k++) {
            dist[k] /= 36.0;
        }
        return dist;
    }

    public static double dice2Sum(int sum) {
        double[] dist = dice2Sum();
        return dist[sum];
    }

    public static Map<Integer, Double> statistics(int[] arr) {
        Map<Integer, Double> probability = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            probability.putIfAbsent(arr[i], 0.0);
            probability.put(arr[i], probability.get(arr[i]) + 1.0);
        }
        Set<Map.Entry<Integer, Double>> set = probability.entrySet();
        for (Map.Entry<Integer, Double> entry : set) {
            Double value = probability.get(entry.getKey()) / arr.length;
            probability.put(entry.getKey(), value);
        }
        return probability;
    }
}
