package org.example;

public class Eggs {

    public static int task(int floors) {
        int sum = 0;
        for (int i = 1; i <= floors; i++)
            if ((sum += i) >= floors) return i;
        return -1;
    }
}