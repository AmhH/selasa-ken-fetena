package com.example.leet.tricky;

public class Test3 {
    /**
     * Q7 — Is it possible to override or overload a static method in Java?
     * Answer
     * It’s possible to overload static Java methods, but it’s not possible to override them. You can write another
     * static method with the same signature in the subclass, but it’s not going to override the superclass method.
     * It’s called method hiding in Java.
     * Q8 — What’s the most reliable way to test whether two double values are equal?
     * Answer
     * The most reliable and accurate way to determine whether two double values are equal to each other is to use
     * Double.compare() and test it against 0.
     * Double.compare(d1, d2) == 0
     */
}
