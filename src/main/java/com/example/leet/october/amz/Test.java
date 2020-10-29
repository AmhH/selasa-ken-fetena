package com.example.leet.october.amz;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews){
        // WRITE YOUR CODE HERE
        Map<String, Long> reviewCount = reviews.stream()
                .flatMap(review -> Arrays.stream(review.split(" ")).distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Collections.sort(competitors, (c1, c2) -> {
            long count1 = reviewCount.getOrDefault(c1, 0l);
            long count2 = reviewCount.getOrDefault(c2, 0l);
            if(count1 == count2){
                return c1.compareTo(c2);
            }
            return (int) (count2 - count1);
        });
        int size = numCompetitors > topNCompetitors ? topNCompetitors : numCompetitors;
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < size; i++){
            result.add(competitors.get(i));
        }

        return  result;
    }

    public int checkWinner1(List<List<String>> codeList,
                           List<String> shoppingCart)
    {
        // WRITE YOUR CODE HERE
        if(null == codeList || codeList.isEmpty()){
            return 1;
        }
        int codeIndex = 0;
        int cartIndex = 0;
        while(codeIndex < codeList.size() && cartIndex < shoppingCart.size()){
            for(int i = 0; i < codeList.get(codeIndex).size(); i++){
                String item = codeList.get(codeIndex).get(i);
                if(item.equals(shoppingCart.get(cartIndex)) || item.equals("anything")){
                    cartIndex++;
                }else{
                    return 0;
                }
            }
            codeIndex++;

        }
        return 1;
    }

    public int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart)
    {
        // WRITE YOUR CODE HERE
        if(null == codeList || codeList.isEmpty()){
            return 1;
        }
        int total = codeList.stream()
                .map(List::size)
                .reduce(0, (a, b) -> a+b);
        return checkWinner(codeList, shoppingCart, 0, total);
    }

    private int checkWinner(List<List<String>> codeList,
                            List<String> shoppingCart,
                            int startIndex, int total){
        int codeIndex = 0;
        int cartIndex = startIndex;
        while(codeIndex < codeList.size() && cartIndex < shoppingCart.size()){
            for(int i = 0; i < codeList.get(codeIndex).size(); i++){
                String item = codeList.get(codeIndex).get(i);
                if(item.equals(shoppingCart.get(cartIndex)) || item.equals("anything")){
                    cartIndex++;
                }else{
                    if(startIndex + total < shoppingCart.size()){
                        return checkWinner(codeList, shoppingCart, startIndex++, total);
                    }
                    return 0;
                }
            }
            codeIndex++;

        }
        return 1;
    }
}
