package com.example.leet.practice;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Marker implements Remote, Cloneable, Serializable {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        int d = a + b ; // TODO returns -2
        int c = Math.addExact(a, b); //TODO throws java.lang.ArithmeticException: integer overflow
        System.out.println(c);
        StringJoiner joiner;
        StringBuffer buffer;

        Runnable runnable;
        Callable callable;
        ConcurrentHashMap map;
        IntSummaryStatistics statistics;
        printMyMame("Jack");
    }

    private static void printMyMame(String name) {
        name = name = "Nelson";

        Runnable r = () -> {
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            //System.out.println("WelCome: " + name);//TODO error should be final or effectively final
        };
        new Thread(r).start();
        System.out.println("Your name is:" +  name);
    }
}

class Demo {

    public static void main(String[] args) {
        Consumer<String> consumer =  Demo::show;
        consumer.accept("Jack");
        consumer.accept("Jill");
        consumer.accept("Ram");
    }

    public static void show(String name){
        System.out.println("w: " + name);
    }
}

class SupplierDemo{

    public static void main(String[] args) {
        List<String> list = Arrays.asList("J", "t");

        list.forEach(f -> {});

        list.stream().forEach(name->{
            showSupplier(()->name);
        });
        System.out.println(Arrays.asList("1", "2", "3").stream().reduce("", String::concat));
    }

    public static void showSupplier(Supplier<String> name){
        System.out.println("W" + name.get());
    }
}
