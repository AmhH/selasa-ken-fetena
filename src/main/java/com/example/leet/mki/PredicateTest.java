package com.example.leet.mki;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> lengther = s -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        Function<String, Boolean> stringer = i -> Boolean.parseBoolean(i);

        System.out.println(booleaner.apply(true));//true => string
        System.out.println(stringer.compose(booleaner).apply(true));//true => boolean
        System.out.println(lengther.negate().or(equalizer).test("CAR"));//true
        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));//true => string
        System.out.println(booleaner.andThen(stringer).apply(true));//true

    }
}
