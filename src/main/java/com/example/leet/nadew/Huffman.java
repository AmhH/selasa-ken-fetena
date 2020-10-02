package com.example.leet.nadew;

import java.util.LinkedList;
import java.util.List;

public class Huffman {

    //repeat 1 - 9
    //return boolean
    //a => a1
    public static boolean isHuffmanShorter(String str){
        int count = 0;
        int index = 0;
        int length = str.length();

        while(index < length){
            int repeat = 1;
            while(index < length -1 && str.charAt(index) == str.charAt(index+1)){
                index++;
                repeat++;
            }
           index ++;
            if(repeat > 2){
                count += repeat - 2;
                if(count > length  - index)
                    return true;
            }
            if(repeat == 1){
                count--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHuffmanShorter("aaabbaaccc"));
        System.out.println(isHuffmanShorter("aaabbaadcc"));
    }

    public List<Integer> combineOrderedLists(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new LinkedList<>();
        int l1 = 0;
        int l2 = 0;

        while(l1 < list1.size() && l2 < list2.size()){
            int t1 = list1.get(l1);
            int t2 = list1.get(l1);
            if (t1 == t2) {
                result.add(t1);
                l1++;
                l2++;
            }else if(t1 < t2){
                result.add(t1);
                l1++;
            }else{
                result.add(t2);
                l2++;
            }
        }
        if(l1 < l2){
            result.addAll(list1.subList(l1, list1.size()));
        }else{
            result.addAll(list2.subList(l2, list1.size()));
        }
        return result;
    }
}
