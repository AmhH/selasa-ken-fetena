package com.example.leet.util;

import java.util.Set;
import java.util.stream.Stream;

public class Book {
    public final String title;
    public final Set<String> authors;
    public final double price;

    public Book(String title, Set<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public static com.example.leet.java9.Book getBook(){
        return new com.example.leet.java9.Book("Java 9", Set.of("Who"), 34.54);
    }

    public static Stream<com.example.leet.java9.Book> getBooks(){
        return Stream.of(new com.example.leet.java9.Book("Java 9", Set.of("Who"), 34.54));
    }
}
