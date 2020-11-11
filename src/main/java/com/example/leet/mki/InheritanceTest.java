package com.example.leet.mki;

public class InheritanceTest {

    public static void main(String[] args) {
        String s1 = "My String";
        String s2 = new String("My String");

        System.out.println(s1 == s2);
        System.out.println(s1.matches(s2));
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}

