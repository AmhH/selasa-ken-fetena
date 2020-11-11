package com.example.leet.mki;

import java.util.Scanner;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (String str : args) {
            if(builder.indexOf(str) < 1){
                builder.append(str + " ");
            }
        }
        System.out.println(builder.toString());
        Scanner scanner = new Scanner(builder.toString());
        while(scanner.hasNext()){
            if(scanner.hasNextInt())
                System.out.println(scanner.nextInt() + " ");
            else
                scanner.next();
        }
    }
}
