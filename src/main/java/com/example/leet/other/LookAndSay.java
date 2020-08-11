package com.example.leet.other;

/**
 *  Look and Say
 * Implement a function that outputs the Look and Say sequence:
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 * 1113213211
 * 31131211131221
 * 13211311123113112211
 */
public class LookAndSay {
    // Returns n'th term in look-and-say sequence
    public static String lookAndSay(int n) {
        // Base cases
        if (n == 1) return "1";
        if (n == 2) return "11";

        // Find n'th term by generating  all terms from 3 to n-1. Every term is generated  using previous term
        // Initialize previous term
        String str = "11";
        for (int i = 3; i <= n; i++) {
            // In below for loop, previous  character is processed in  current iteration. That is why a dummy character is
            // added to make sure that loop runs one extra iteration.
            str += '$';
            int len = str.length();

            int cnt = 1; // Initialize count  of matching chars
            String tmp = ""; // Initialize i'th   term in series
            char[] arr = str.toCharArray();

            // Process previous term to find the next term
            for (int j = 1; j < len; j++) {
                if (arr[j] != arr[j - 1]) { // If current character does't match
                    tmp += cnt + 0;   // Append count of str[j-1] to temp
                    tmp += arr[j - 1]; // Append str[j-1]
                    cnt = 1; // Reset count
                }
                else
                    cnt++; // If matches, then increment  count of matching characters
            }
            // Update str
            str = tmp;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(3));
        System.out.println(lookAndSay(8));
    }
}
