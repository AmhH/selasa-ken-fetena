package com.example.leet.april.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //collection List, queue, stack, vector, linked list array list, set , map

        List<Integer> list = new ArrayList<>();
        Vector<String> strings = new Vector<>();
        strings.stream();
        strings.parallelStream();

        list.stream();
        list.parallelStream();

        Stream<Integer> integerStream = list.stream()
                        .map(x -> x * x)
                        .filter(x -> x==0);

        long count = list.stream().map(x -> x * x).filter(x -> x==0).count();

    }
}
