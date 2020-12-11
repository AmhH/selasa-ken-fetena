package com.example.leet.java10;

import java.util.PriorityQueue;

public class TestTMo {

  public static void main(String[] args) {
    long t = getKey(310l);
    System.out.println(t);
  }

  private static long getKey(long l) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>((a, b) -> (int) (b - a));
    while (l > 0) {
      long mod = l % 10;
      minHeap.offer(mod);
      l = l / 10;
    }
    StringBuilder builder = new StringBuilder();
    while (!minHeap.isEmpty()) {
      builder.insert(0, minHeap.poll());
    }
    int zeros = builder.lastIndexOf("0");
    if (zeros > -1) {
      builder.replace(0, 1, String.valueOf(builder.charAt(zeros + 1)));
      builder.replace(zeros + 1, zeros + 2, "0");
    }

    return Long.parseLong(builder.toString());
  }

  int[][] rotatePictureMethod(int[][] img, int rows, int columns,
      int flag) {
    for (int r = 0; r < rows / 2; r++) {
      for (int c = r; c < columns - r - 1; c++) {
        int temp = img[r][c];
        // Move values from right to top
        img[r][c] = img[c][columns - 1 - r];
        // Move values from bottom to right
        img[c][columns - 1 - r] = img[rows - 1 - r][columns - 1 - c];
        // Move values from left to bottom
        img[rows - 1 - r][columns - 1 - c] = img[rows - 1 - c][r];
        // Assign temp to left
        img[rows - 1 - c][r] = temp;
      }
    }
    return img;
  }


  int[][] rotatePictureMethod1(int[][] img, int rows, int columns,
      int flag) {

    // Traverse each cycle
    for (int r = 0; r < rows / 2; r++) {
      for (int c = r; c < columns - r - 1; c++) {
        int temp = img[r][c];
        img[r][c] = img[rows - 1 - c][r];
        img[rows - 1 - c][r] = img[rows - 1 - r][columns - 1 - c];
        img[rows - 1 - r][columns - 1 - c] = img[c][columns - 1 - r];
        img[c][columns - 1 - r] = temp;
      }
    }
    return img;
  }
}
