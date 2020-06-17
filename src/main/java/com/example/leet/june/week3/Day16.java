package com.example.leet.june.week3;

/**
 * Validate IP Address
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
 * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the
 * address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros
 * and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons
 * (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 * Example 1:
 * Input: "172.16.254.1"
 *
 * Output: "IPv4"
 *
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * Output: "IPv6"
 *
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 *
 * Output: "Neither"
 *
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class Day16 {

    public static String validIPAddress(String IP) {

        String ipv4 = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" +
                "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String ipv6 = "((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}";
        if(IP.matches(ipv4))
            return "IPv4";
        if(IP.matches(ipv6))
            return "IPv6";

        return "Neither";
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIPAddress("256.256.256.256"));
    }
    class Solution {

        final char v4Delimiter = '.';
        final char v6Delimiter = ':';

        public String validIPAddress(String IP) {
            int slowPointer = 0;
            int validSegments = 0;
            char[] chars = IP.toCharArray();
            char firstDelimiter = ' ';

            for (int i = 0; i < chars.length; i++) {
                final char current = chars[i];
                final int offset = i - slowPointer;

                if (current == v4Delimiter) {
                    if (firstDelimiter == v6Delimiter) return "Neither";
                    if (firstDelimiter == ' ') firstDelimiter = v4Delimiter;
                    if (offset < 1 || offset > 3) return "Neither";
                    if (isInvalidIPV4Segments(slowPointer, chars, offset)) return "Neither";
                    slowPointer = i + 1;
                    validSegments++;

                } else if (current == v6Delimiter) {
                    if (firstDelimiter == v4Delimiter) return "Neither";
                    if (firstDelimiter == ' ') firstDelimiter = v6Delimiter;
                    if (offset < 1 || offset > 4) return "Neither";
                    if (isInvalidIPV6Segment(slowPointer, chars, i)) return "Neither";
                    slowPointer = i + 1;
                    validSegments++;

                }
                if (i == chars.length - 1) {
                    final int offsetFinal = i - slowPointer + 1;
                    if (firstDelimiter == v4Delimiter) {
                        if (offsetFinal < 1 || offsetFinal > 3) return "Neither";
                        if (isInvalidIPV4Segments(slowPointer, chars, offsetFinal)) return "Neither";
                    } else if (firstDelimiter == v6Delimiter) {
                        if (offsetFinal < 1 || offsetFinal > 4) return "Neither";
                        if (isInvalidIPV6Segment(slowPointer, chars, i)) return "Neither";
                    }

                    validSegments++;
                }

                if (firstDelimiter == '.' && validSegments == 4 && i == chars.length - 1) return "IPv4";
                if (firstDelimiter == ':' && validSegments == 8 && i == chars.length - 1) return "IPv6";
            }

            return "Neither";


        }

        private boolean isInvalidIPV6Segment(int slowPointer, char[] chars, int i) {
            for (int j = slowPointer; j < i; j++) {
                char c = chars[j];
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                    return true;
            }
            return false;
        }

        private boolean isInvalidIPV4Segments(int slowPointer, char[] chars, int offset) {
            char first = chars[slowPointer];
            if (offset == 3) {
                char second = chars[slowPointer + 1];
                char third = chars[slowPointer + 2];
                if (first == '2') {
                    if (second < '0' || second > '5') return true;
                    if (second == '5') {
                        return third < '0' || third > '5';
                    } else {
                        return third < '0' || third > '9';
                    }
                } else if (first == '1') {
                    if (second < '0' || second > '9') return true;
                    return third < '0' || third > '9';
                } else return true;
            } else if (offset == 2) {
                char second = chars[slowPointer + 1];
                if (first < '1' || first > '9') return true;
                return second < '0' || second > '9';
            } else {
                return first < '0' || first > '9';
            }
        }

    }

    class Solution1 {
        public String validIPAddress(String IP) {
            if(IP.indexOf(':')!=-1){
                String[] s=IP.split(":",-1);

                //System.out.println(s.length);
                if(s.length!=8)return "Neither";
                for(int i=0;i<s.length;i++){
                    //System.out.println(s[i]);
                    if(s[i].isEmpty() || s[i].length()>4)return "Neither";
                    for(char c:s[i].toCharArray()){
                        if(!(('0'<=c && c<='9')||('A'<=c && c<='F')||('a'<=c && c<='f')))return "Neither";
                    }
                }
                return "IPv6";
            }
            else if(IP.indexOf('.')!=-1){
                String[] s=IP.split("\\.",-1);
                if(s.length!=4)return "Neither";
                for(int i=0;i<s.length;i++){
                    try{
                        int j=Integer.parseInt(s[i]);
                        if((s[i].length()>1 && s[i].charAt(0)=='0')|| s[i].charAt(0)=='-' || s[i].charAt(0)=='+' || j>255)return "Neither";
                    }
                    catch(Exception e){
                        return "Neither";
                    }
                }
                return "IPv4";
            }
            return "Neither";
        }
    }
}
