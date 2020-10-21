package com.example.leet.october.week3;

import java.util.*;

/**
 * Repeated DNA Sequences
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example 1:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 * Example 2:
 *
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 105
 * s[i] is 'A', 'C', 'G', or 'T'.
 */
public class Day17 {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 10) return res;

        Map<String, Integer> counts = new HashMap<>();
        for(int i = 10; i <= s.length(); i++) {
            String substr = s.substring(i-10, i);
            if(counts.containsKey(substr) && counts.get(substr) == 1) {
                res.add(substr);
            }
            counts.put(substr, counts.getOrDefault(substr, 0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));//["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));//["AAAAAAAAAA"]
    }

    private final static int[] map = new int[128];

    static {
        map['A'] = 0; map['C'] = 1; map['G'] = 2; map['T'] = 3;
    }

    public List<String> findRepeatedDnaSequences4(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10) return ans;
        char[] chars = s.toCharArray();
        boolean[] hashCodeMap = new boolean[1048576], added = new boolean[1048576];

        int hashCode = 0, i = 0;
        for (; i < 10; i++) {
            hashCode = (hashCode << 2) + map[chars[i]];
        }
        hashCodeMap[hashCode] = true;
        for (; i < chars.length; i++) {
            hashCode = ((hashCode << 2) & 0xFFFFF) + map[chars[i]];

            if (hashCodeMap[hashCode] && !added[hashCode]) {
                ans.add(new String(chars,i-9,10));
                added[hashCode] = true;
            }
            hashCodeMap[hashCode] = true;
        }

        return ans;
    }

    //This is a sort of queue ..where A is 00, C-01, G-10, T-11
    //we first ..start adding the values to the number..by bit mask and bit shift
    //when we reach 10 length (which is same as 20 bits in binary)... we need to check if we have seen this earlier
    //for next incoming character (11th position).. we will need to remove the character at the beginning..
    // to keep the length of the queue to 10
    //to drop the first character.. we did value &= 0xfffff (1048575  or binary 11111111111111111111) ..which is 20 set bits
    //the first character is represented by 2 bits...so to drop the first 2 bits from 22 bits number...we used above logic
    //Eg: 11101011111111111011 -- 20 bits (10 characters)
    //    1110101111111111101100 -- 22 bits (11 characters)
    //    1110101111111111101100  -- do And operation
    //  &   11111111111111111111  -- with 20 set bits
    //Ans:  10101111111111101100  -- First 2 bits are dropped from 22 bit number
    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<>();
        Set<Integer> word = new HashSet<>();
        Set<Integer> secondWord = new HashSet<>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            System.out.println(Integer.toBinaryString(value));
            value &= 0xfffff;//1048575
            System.out.println(Integer.toBinaryString(value));
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
}
