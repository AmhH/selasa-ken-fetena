package com.example.leet.java10;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;

public class LocalVariable {

    public static void main(String[] args) {
        //var num;
        var hi = "Hi";//type inferred by compiler
        var var = "var";//var reserved type link int
        Predicate<String> p = s -> s.length() > 3;
        Predicate<String> p11 = (String s) -> s.length() > 3;
        //var p1 = s -> s.length() > 3; not enough information to infer
        //var p1 = (String s) -> s.length() > 3;

        var nums = new int[]{1,2,3};
        //var nums1 = {1,2,3}; not enough information
        var strs = List.of(hi);
        var copy = List.copyOf(strs);

        Duration.between(Instant.now(), Instant.now());

    }
}
