package com.example.leet.util;

import java.util.Optional;

public class Java9 {
    public static void main(String[] args) {
        Optional<Book> full = Optional.of(Book.getBook());
        //before
        full.ifPresent(System.out::println);

        if(full.isPresent()){
            System.out.println(full.get());
        }else {
            System.out.println("Nothing");
        }

        //Java 9
        full.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing here"));
        Optional.empty().ifPresentOrElse(System.out::println, () -> System.out.println("Nothing here"));


    }
}
