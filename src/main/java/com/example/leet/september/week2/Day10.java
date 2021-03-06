package com.example.leet.september.week2;

/**
 *  Bulls and Cows
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits
 * match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
 * and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are
 * always equal.
 */
public class Day10 {
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));//"1A3B"
        System.out.println(getHint1("1123", "0111"));//"1A1B"
    }

    public static String getHint1(String secret, String guess) {

        int c = 0, b = 0;
        int[] map = new int[10];

        for(int i=0;i<secret.length();i++){
            int ch1 = secret.charAt(i)-'0';
            map[ch1]++;
        }

        for(int i=0;i<secret.length();i++){
            int ch1 = secret.charAt(i)-'0';
            int ch2 = guess.charAt(i)-'0';
            if(ch1 == ch2){
                b++;
                map[ch2]--;
            }
        }

        for(int i=0;i<secret.length();i++){
            int ch1 = secret.charAt(i)-'0';
            int ch2 = guess.charAt(i)-'0';
            if(ch1 != ch2 && map[ch2]>0){
                c++;
                map[ch2]--;
            }
        }

        StringBuilder sb = new StringBuilder("");
        sb.append(b);
        sb.append("A");
        sb.append(c);
        sb.append("B");

        return sb.toString();
    }
}
