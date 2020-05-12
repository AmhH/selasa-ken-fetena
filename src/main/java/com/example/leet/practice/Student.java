package com.example.leet.practice;

import java.util.HashMap;
import java.util.Map;

public final class Student {

    private final String name;
    private final int regNo;
    private final Map<String, String> map;

    public Student(String name, int regNo, Map<String, String> map) {
        this.name = name;
        this.regNo = regNo;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public static void main(String[] args) {
        Student student = new Student("Mame", 67, new HashMap<>());

        System.out.println("Name before: " + student.getName());
        student.getName().replace("M", "A"); // Aame
        System.out.println("Name after: " + student.getName());

        System.out.println("map before " + student.getMap());

        student.getMap().put("Mame", "Chala");

        System.out.println("map After " + student.getMap());
    }
}
