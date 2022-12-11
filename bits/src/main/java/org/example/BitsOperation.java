package org.example;

public class BitsOperation {

    public static int task(int a) {
        String binary = Integer.toBinaryString(a);

        if (~a == 0) return Integer.BYTES * 8;

        int currLength = 0;
        int prevLength = 0;
        int maxLength = 1;
        String space = "0";
        while (a != 0) {
            if ((a & 1) == 1) {
                currLength++;
            } else if ((a & 1) == 0) {
                prevLength = currLength;
                currLength = 0;
            }
            maxLength = Math.max(prevLength + currLength + 1, maxLength);
            // a >>>= 1;
            System.out.println(space + Integer.toBinaryString(a >>>= 1));
            space += "0";
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int n = -2;
        System.out.println(Integer.toBinaryString(n));/*
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n>>>3));*/
        System.out.println("Number of ones in the longest sequence: " + task(n));
    }
}
