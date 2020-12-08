package com.example.leet.java10;

import java.util.HashMap;
import java.util.Map;

public class AmeriSave {

  public static void main(String[] args) {
    printReverseOrder("Hello");
  }

  private static void printReverseOrder(String str) {
    StringBuilder builder = new StringBuilder(str);
    StringBuilder reverse = builder.reverse();
    for (int i = 0; i < reverse.length(); i++) {
      String s = i%2 == 0 ? String.valueOf(reverse.charAt(i)).toLowerCase() :
          String.valueOf(reverse.charAt(i)).toUpperCase();

      reverse.replace(i, i+1, s);
    }
    System.out.println(reverse);
  }

  public void loopThroughArrayAndHashMap(){
    //array
    Object[] array = new Object[4];
    Object[] array2 = {1, 2, "3", "4"};
    array[0] = 1;
    array[1] = 2;
    array[2] = "1";
    array[3] = "2";
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
    for (Object o : array2){
      System.out.println(o);
    }

    //HashMap
    Map<String, Integer> map = new HashMap<>();
    map.put("1", 1);
    map.put("2", 2);
    map.put("3", 3);
    map.forEach((k, v) -> System.out.println(k + " " + v));
    for(Map.Entry<String, Integer> entry : map.entrySet()){
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}
