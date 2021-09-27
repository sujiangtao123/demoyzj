package com.company.Test.tree;

public class ArrBinaryTreeDemo {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        prOrder(0);

    }

    private static void prOrder(int index) {
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {//左边递归遍历
            prOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {//右边递归遍历
            prOrder(2 * index + 2);
        }
    }
}
