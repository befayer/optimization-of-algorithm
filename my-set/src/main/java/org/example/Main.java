package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    /**
     * --1--
     * int[] value
     * [null][null][null][null][null][null][null][null][null][null]
     * int[] indexes
     * [-1][-1][-1][-1][-1][-1][-1][-1][-1][-1]
     *
     * --2--
     * int[] value
     * value = 3
     * [null][null][3][null][null][null][null][null][null][null]
     * int[] indexes
     * [-1][-1][2][-1][-1][-1][-1][-1][-1][-1]
     */

    static Random random = new Random();
    private static final int ARRAY_LENGTH = 20_000_000;

    public static void main(String[] args) {

        int[] arr1 = new int[ARRAY_LENGTH];
        int[] arr2 = new int[ARRAY_LENGTH];

        initArray(arr1, arr2);

        long time = System.currentTimeMillis();

        testDefaultSet(arr1, arr2);

        long timeDefaultSet = (System.currentTimeMillis() - time);
        System.out.println("Execution time of method with default Set: " + timeDefaultSet + "ms");

        time = System.currentTimeMillis();
        testMySet(arr1, arr2);
        long timeMySet = (System.currentTimeMillis() - time);
        System.out.println("Execution time of method with my Set: " + timeMySet + "ms");

        System.out.println("Difference: " + (double) timeDefaultSet / timeMySet);
    }

    public static void initArray(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt();
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt();
        }
    }

    public static int[] testDefaultSet(int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) return testDefaultSet(arr2, arr1);
        Set<Integer> set = new HashSet<>();
        int[] result = new int[arr1.length];
        for (int value : arr1) {
            set.add(value);
        }
        int j = 0;
        for (int k : arr2) {
            if (set.contains(k)) {
                result[j++] = k;
            }
        }
        return Arrays.copyOf(result, j);
    }

    public static int[] testMySet(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return testMySet(arr2, arr1);
        MySet<Integer> set = new MySet<>(arr1.length);
        int[] result = new int[arr1.length];
        for (int k : arr1) {
            set.add(k);
        }
        int j = 0;
        for (int k : arr2) {
            if (set.contains(k)) {
                result[j++] = k;
            }
        }
        return Arrays.copyOf(result, j);
    }
}
