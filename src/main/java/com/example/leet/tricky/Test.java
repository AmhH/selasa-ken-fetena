package com.example.leet.tricky;

/**
 * What is the output of the given Java code?
 */
public class Test {
    public static void main(String[] args) {
        method(null);
    }
    public static void method(Object o) {
        System.out.println("Object method");
    }
    public static void method(String s) {
        System.out.println("String method");
    }
    /**
     * Answer
     * It will print “String method”. First of all, null is not an object in Java. But we know that we can assign
     * null to any object reference type in Java. Java String is also an object of the class java.lang.String. Here,
     * the Java compiler chooses to call the overloaded method with the most specific parameters. Which would be
     * String because the String class is more specific than the Object class.
     */
}