package com.example.leet.mki;

import java.io.*;
import java.util.Optional;

class Parent {
    protected static int count = 0;
    public Parent(){
        count++;
    }
    static int getCount(){return count;}
}

public class Child extends Parent{
   public Child(){
       count++;
   }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Count = " + getCount());
        Child obj = new Child();
        System.out.println("Count = " + getCount());
        Object o = new Object();

        Optional<String> f = Optional.of("file.java");
        File file = new File(f.get());
        FileOutputStream stream = new FileOutputStream(file);
        //RandomAccessFile randomAccessFile = new RandomAccessFile(file);
        InputStream inputStream = new FileInputStream(file);
        Reader reader = new FileReader(file);
    }
}