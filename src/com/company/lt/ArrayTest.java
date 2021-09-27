package com.company.lt;

import org.junit.Test;

import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 5, 2, 3};
        int target = 9;
        int[] anInt = getInt(a, target);
//        Arrays.stream(anInt).forEach(System.out::println);
//        System.out.println(longestCommonPrefix());
//        System.out.println(searchInsert());
        System.out.println(climbStairs(4));

    }

    public static int[] getInt(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int complete = target - num[i];
            if (map.containsKey(complete)) {
                return new int[]{map.get(complete), i};
            }
            map.put(num[i], i);
        }
        throw new RuntimeException();
    }

    @Test
    public void reverse() {
        int x = 121;
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        System.out.println(n);
        int m = (int) n;
        System.out.println(x == m);

    }

    @Test
    public void isPalin() {
        int x = 121;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        String ss = "";
        while (stack.size() > 0) {
            ss = ss + stack.pop();
        }
        System.out.println(s.equals(ss) ? true : false);

    }

    @Test
    public void symbol() {
        String s = "IVX";
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            Integer value = map.get(chars[i]);
            if (i < length - 1 && value < map.get(chars[i + 1])) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        System.out.println(ans);
    }

    //    @Test
    public static String longestCommonPrefix() {
        String[] strArray = {"dog", "racecar", "car"};
        int arrayLength = strArray.length;
        int length = strArray[0].length();
        for (int i = 0; i < length; i++) {
            char c = strArray[0].charAt(i);
            for (int j = 1; j < arrayLength; j++) {
                if (i >= strArray[j].length() || strArray[j].charAt(i) != c) {
                    return strArray[0].substring(0, i);
                }
            }
        }
        return strArray[0];
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');

        }};
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || pairs.get(c) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void strStr() {
        String haystack = "haystack", needle = "ays";
        char[] stackArray = haystack.toCharArray();
        char[] neeArray = needle.toCharArray();
        int length = haystack.length();
        int length1 = needle.length();
        int i = 0, j = 0;
        while (i < length && j < length1) {
            if (stackArray[i] == neeArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == length1) {
            System.out.println(i - j);
        }
    }

    @Test
    public void str() {
        String haystack = "haystack", needle = "astac";
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                System.out.println(i - j + 1);
                break;
            }
        }
    }

    public static int searchInsert() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void maxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println(max);
    }

    @Test
    public void addBinary() {
        String a = "11", b = "11";
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        System.out.println(ans.toString());
    }

    @Test
    public void mySqrt() {
        int x = 8;
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int dep_pre_pre = 1;
        int dep_pre = 2;
        int index = 3;
        int cur = 0;
        while (index <= n) {
            cur = dep_pre_pre + dep_pre;
            dep_pre_pre = dep_pre;
            dep_pre = cur;
            index++;
        }
        return cur;

    }
}
