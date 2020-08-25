package com.example.leet.cap;

public class FindSmallestDivisor {

    public static int findSmallestDivisor(String s, String t){
        if(!checkConcat(s, t))
            return -1;
        char first = t.charAt(0);
        int next = t.indexOf(first, 1);
        while (next != -1){
            String sub = t.substring(0, next);
            if(checkConcat(t, sub)){
                return sub.length();
            }
            next = t.indexOf(first, next + 1);
        }
        return t.length();
    }

    private static boolean checkConcat(String s, String t) {
        int sl = s.length();
        int tL = t.length();
        if(sl % tL != 0){
            return false;
        }
        for (int i = 0; i < sl; i++) {
            if(s.charAt(i) != t.charAt(i % tL)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(findSmallestDivisor("bcdbcdbcdbcd", "bcdbcd"));
        //System.out.println(findSmallestDivisor("lrbb", "lrbb"));
        //System.out.println(findSmallestDivisor("rbrb", "rbrb"));
        System.out.println(findSmallestDivisor("bcdbdcbcdbdcbcdbdcbcdbdc", "bcdbdcbcdbdc"));
    }
}
