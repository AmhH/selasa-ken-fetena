package com.example.leet.practice;

public class CommonSubString {
    public static void commonSubstring(String[] a, String[] b) {
        // a = ['ab','cd','ef'] a[i]
        // b = ['af', 'ee', 'ef']
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b[i])) {
                System.out.println("YES " + a[i]);
                break;
            }
            outerLoop:
            for (int j = 0; j < a[i].length(); j++) {
                for (int k = 0; k < b[i].length(); k++) {
                    if (a[i].charAt(j) == b[i].charAt(k)) {
                        System.out.println("YES " + a[i]);
                        break outerLoop;
                    }
                    if (j == (a[i].length() - 1) && k == (b[i].length() - 1)) {
                        System.out.println("NO " + a[i]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] a = {"ab", "cd", "ef"};
        String[] b = {"af", "ee", "ef"};
        commonSubstring(a, b);
        System.out.println("***********************");
        commonSubstring2(a, b);
    }

    public static void commonSubstring2(String[] a, String[] b) {

        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b[i])) {
                System.out.println("YES " + a[i]);
                break;
            }

            for (int j = 0; j < a[i].length(); j++) {
                if (b[i].indexOf(a[i].charAt(j)) > -1) {
                    System.out.println("YES " + a[i]);
                    break;
                }
                if(j == a[i].length() - 1)
                System.out.println("NO " + a[i]);
            }
        }

    }


}
