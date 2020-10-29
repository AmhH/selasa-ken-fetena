package com.example.leet.other;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Main process = new Main();
        process.findPair(200.00, "src/main/java/com/example/leet/other/giftList.txt");
        process.findPair(30.00, "src/main/java/com/example/leet/other/giftList.txt");
        process.findPair(75.00, "src/main/java/com/example/leet/other/giftList.txt");
        process.findPair(900.00, "src/main/java/com/example/leet/other/giftList.txt");
        process.findPair(700.00, "src/main/java/com/example/leet/other/giftList.txt");
    }

    public void findPair(double budget, String fileName) throws IOException, URISyntaxException {
        NavigableMap<Double, List<Item>> itemsMap = readFromFileAndMap(fileName); //reds listed items from file
        double sum = 0;
        List<Item> result = new ArrayList<>();
        for(Map.Entry<Double, List<Item>> entry : itemsMap.entrySet()){
            double sub = budget - entry.getKey();
            Map.Entry<Double, List<Item>> lowerEntry = itemsMap.lowerEntry(sub);
            if(null != lowerEntry){
                double currentSum = entry.getKey() + lowerEntry.getKey();
                if(currentSum > sum){
                    result.add(0, lowerEntry.getValue().get(0));
                    result.add(1, entry.getValue().get(0));
                    sum = currentSum;
                }
            }
        }

        if(!result.isEmpty()) {
            System.out.println("You can buy: " + result.get(0)  + " and ");
            System.out.println(result.get(1));
        }else {
            System.out.println("No Solution");
        }
    }


    private NavigableMap<Double, List<Item>> readFromFileAndMap(String fileName) throws IOException,
            URISyntaxException{
        //Path path = Paths.get(this.getClass().getResource(fileName).toURI());
        Path path = Paths.get(fileName);
        return Files.readAllLines(path, Charset.defaultCharset())
                .stream()
                .map(item -> item.split(", "))
                .filter(arr -> 2 == arr.length)
                .map(arr -> new Item(arr[0], Double.parseDouble(arr[1].trim())))
                .collect(Collectors.groupingBy(item -> item.getPrice(), TreeMap::new, Collectors.toList()));
    }
}
//1. Big-O notation => nlogn
//2. add parameter to method signature and recurse for n-1 solution inside the for loop
//3. Filter out items with prices more than the budget