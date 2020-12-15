package com.example.leet.java10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.IntSummaryStatistics;
import java.util.function.Function;

public class AmAdvrt {

  public static void main(String[] args) {

  }

  public static boolean checkPowerOfTwo(int n){
    if(n < 1)
      return false;
    while (n != 1){
      if(n%2 == 1)
        return false;
      n /= 2;
    }
    return true;
  }

  public static boolean checkPowerOfTwo1(int n){
    if(n < 1)
      return false;
    return (n & (n-1)) == 0;
  }

  public static long addNumbers(long a, long b){
    return a + b;
  }

  public static void jointMembership(){
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    List<Integer> all = new ArrayList<>();
    List<Integer> elementInOneList = new ArrayList<>();
    Set<Integer> unique = new HashSet<>();
    //All
    all.addAll(a);
    all.addAll(b);
    System.out.println("All Elements: " + all);
    //in one list
    Set<Integer> aSet = new HashSet<>(a);
    Set<Integer> bSet = new HashSet<>(b);
    addUnique(aSet, bSet, elementInOneList);
    addUnique(bSet, aSet, elementInOneList);
    System.out.println("Exactly in One list: " + elementInOneList);
    //unique
    unique.addAll(a);
    unique.addAll(b);
    System.out.println("Unique elements: " + unique);
  }

  public static void addUnique(Set<Integer> a, Set<Integer> set, List<Integer> elementInOneList){
    for(Integer i : a){
      if(set.contains(i))
        elementInOneList.add(i);
    }
  }

  public double average(List<Integer> list){
    return list.parallelStream().mapToInt(a -> a).summaryStatistics().getAverage();
  }

  public boolean anagrams(String str1, String str2){
    char[] new1 = sanitizeString(str1).toCharArray();
    char[] new2 = sanitizeString(str2).toCharArray();

    if(new1.length != new2.length)
      return false;
    int[] count1 = new int[26];
    int[] count2 = new int[26];
    for (int i = 0; i < new1.length; i++){
      count1[new1[i] - 'a']++;
      count2[new2[i] - 'a']++;
    }

    for (int i = 0; i < count1.length; i++){
      if(count1[i] != count2[i])
        return false;
    }
    StringBuilder builder = new StringBuilder();
    builder.length();
    return true;
  }

  private String sanitizeString(String str) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(Character.isLetter(c)){
        char c1 = Character.toLowerCase(c);
        builder.append(c1);
      }
    }
    return builder.toString();
  }
}
