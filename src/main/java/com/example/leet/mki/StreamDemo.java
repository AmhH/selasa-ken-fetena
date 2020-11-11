package com.example.leet.mki;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dog", "over", "good");

        list.stream().reduce((x1, x2) -> x1.length() == 3 ? x1 : x2).ifPresent(System.out::println);
        list.stream().reduce((x1, x2) -> x1.length() == x2.length() ? x1 : x2).ifPresent(System.out::println);
        /*list.stream().reduce(new Character(), (Character s1, s2) -> s1 + s2.charAt(0), (c1, c2) -> c1 += c2);*/
        System.out.println(list.stream().reduce(new String(), (s1, s2) -> s1 + s2.charAt(0), (c1, c2) -> c1 += c2));
        System.out.println(list.stream().reduce(new String(), (s1, s2) -> s1.equals("dog") ? s1 : s2));
    }
}
