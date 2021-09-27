package com.company.Test.search;

import java.util.Arrays;

public class Kmp {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] ints = KmpNext(str2);
        System.out.println(Arrays.toString(ints));
        System.out.println(kmp(str1, str2, ints));
    }

    //获取到子串的部分匹配值
    private static int[] KmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];//kmp算法核心
            }
            if (dest.charAt(i) == dest.charAt(j)) {//代表dest字符串是一样的字符
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    //str1源字符串 str2子串  next部分匹配表
    private static int kmp(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
