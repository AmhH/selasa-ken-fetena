package com.example.leet.util;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.leet.util.Book.getBook;
import static com.example.leet.util.Book.getBooks;
import static java.util.stream.Collectors.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Java9Test {

    @Test
    public void testCollectionFactoryMethods(){
        List<String> list = List.of("");//returns ImmutableCollections$List12
        assertThat(List.of("").size(), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCollectionFactoryMethodsSet(){
        Set.of("a", "a");
    }

    @Test
    public void testCollectionFactoryMethodsMap(){
        Map.of("Key1", 1, "key2", 2);
        Map.ofEntries(Map.entry("Key", "value"));
    }

    @Test
    public void testStreamTakeWhileAndDropWhile() throws IOException {
        //git conflicts
        Files.lines(Paths.get("resources/index.html"))
                .dropWhile(l -> !l.contains("<<<<<<<"))
                .skip(1)
                .takeWhile(l -> !l.contains(">>>>>>>"))
                .forEach(System.out::println);
    }

    @Test
    public void testStreamOfNullable(){
        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(getBook()).count();
        System.out.printf("Zero: %d, one: %d", zero, one);
    }

    @Test
    public void testCollectorsFiltering() {
        Set<Book> collect = getBooks().collect(filtering(b -> b.getPrice() > 10, toSet()));
        Map<Set<String>, Set<Book>> books = getBooks()
                .collect(groupingBy(Book::getAuthors, filtering(b -> b.getPrice() > 10, toSet())));
    }

    @Test
    public void testCollectorsFlatMapping() {
        Map<Double, Set<String>> collect = getBooks()
                .collect(groupingBy(Book::getPrice, flatMapping(b -> b.getAuthors().stream(), toSet())));
    }
}