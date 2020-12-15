package com.example.leet.util;

import java.util.Arrays;

public class Solution {
  static String[] fizzBuzz(int n) {
    String[] result = new String[n];
    for(int i = 1; i <= n; i++){
      if(i%3 == 0 && i%5 == 0){
        result[i - 1] = "FizzBuzz";
      }else if(i%5 == 0){
        result[i - 1] = "Buzz";
      }else if(i%3 == 0){
        result[i - 1] = "Fizz";
      }else{
        result[i - 1] = String.valueOf(i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(fizzBuzz(15)));
  }
}
