package com.example.leet.august.week3;

/**
 * Goat Latin
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase
 * letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add
 * "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class Day19 {

    public static String toGoatLatin(String S) {
        if(S == null || S.isBlank())
            return S;
        int index = 0;
        int wordCount = 1;
        String vowels = "AEIOUaeiou";
        StringBuilder builder = new StringBuilder();

        while (index >= 0 && index < S.length()){
            if (0 != index)
                builder.append(" ");
            char c = S.charAt(index);
            int nextIndex = S.indexOf(" ", index);
            nextIndex = nextIndex == -1 ? S.length() : nextIndex;
            boolean isVowel = vowels.indexOf(c) != -1;
            String word = S.substring(index, nextIndex);
            if(isVowel){
                builder.append(word);
            }else {
                builder.append(word.substring(1)).append(c);
            }
            builder.append("ma").append("a".repeat(wordCount));
            wordCount++;
            index = nextIndex + 1;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
