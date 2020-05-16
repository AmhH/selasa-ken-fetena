package com.example.leet.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomGenerate {

    public static int n = 100000;
    public static void main(String[] args) {
        System.out.println("hello".replace("K", "H"));
        int[] a = new int[2];
        System.out.println(a.toString());

        int k;
        int arr[] = new int[n];
        Random rand = new Random(500);
        for (k=0; k<n; k++)
            arr[k] = rand.nextInt(100000);

        long start = System.currentTimeMillis();
        int[] ints = Arrays.stream(arr)
                //.parallel()
                .sorted()
                .toArray();
        long end = System.currentTimeMillis();

        System.out.println("Sorted *************************************" + (end - start));

    }
}
