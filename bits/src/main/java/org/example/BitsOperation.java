package org.example;

public class BitsOperation {

    public static int task(int a) {
        String binary = Integer.toBinaryString(a);
        if (~a == 0) return Integer.toBinaryString(a).length() + 1;

        int currLength = 0;
        int prevLength = 0;
        int maxLength = 1;
        while (a != 0) {
            if ((a & 1) == 1) {
                currLength++;
            } else if ((a & 1) == 0) {
                prevLength = currLength;
                currLength = 0;
            }
            maxLength = Math.max(prevLength + currLength + 1, maxLength);
            // a >>>= 1;
            System.out.println(Integer.toBinaryString(a >>>= 1));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int n = 467;
        System.out.println(Integer.toBinaryString(n));/*
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n>>>3));*/
        System.out.println(task(n));
    }
}
