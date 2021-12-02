package com.company.lt;

import java.awt.geom.FlatteningPathIterator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ArraySort2 {
    public static void main(String[] args) {
//        System.out.println(isHappy(19));
//        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 4, 2}, 3));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));

    }

    // lc 202题目 快乐数
    private static int getNext(int n) {
        int totalNum = 0;
        while (n > 0) {
            //个位数
            int m = n % 10;
            //位数向前移动-百位....
            n /= 10;
            totalNum += m * m;
        }
        return totalNum;
    }

    public static boolean isHappy(int n) {
        //快慢指针
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (slowRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return slowRunner == 1;
    }

    // lc 205题 同构字符串
    public static boolean isIsomorphic(String s, String t) {
        // 方法1
//        return isIsomorphicSame(s, t) && isIsomorphicSame(t, s);
        //方法2 时间不如1快
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphicSame(String s, String t) {
        HashMap<Character, Character> smp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char m = s.charAt(i), n = t.charAt(i);
            if (smp.containsKey(m)) {
                if (smp.get(m) != n) {
                    return false;
                }
            } else {
                smp.put(m, n);
            }
        }
        return true;
    }

    // lc 217题 数组存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // lc 219题目 存在重复元素II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // lc 228. 汇总区间
    public static List<String> summaryRanges(int[] nums) {
        LinkedList<String> list = new LinkedList<>();
        if (nums.length == 0) {
            return list;
        }
        // 借助双指针
        int m = 0;
        for (int n = 0; n < nums.length; n++) {
            if (n == nums.length - 1 || nums[n] != nums[n + 1] - 1) {
                StringBuilder stringBuilder = new StringBuilder(nums.length);
                stringBuilder.append(nums[m]);
                //区间拼接
                if (n != m) {
                    stringBuilder.append("->").append(nums[n]);
                }
                m = n + 1;
                list.offer(stringBuilder.toString());
            }
        }
        return list;
    }

    // lc 231. 2 的幂
    public static boolean isPowerOfTwo(int n) {
        // 出自hash源码
        return n > 0 && (n & (n - 1)) == 0;
    }
}
