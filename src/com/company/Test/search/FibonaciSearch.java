package com.company.Test.search;

import java.util.Arrays;

public class FibonaciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibonaciSearch(arr, 89));
    }

    //得到一个斐波那契数列
    private static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 20; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //key需要查找的元素
    private static int fibonaciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//斐波那契的下标值
        int mid = 0;//存放mid值
        int[] f = fib();
        while (f[k] < high + 1) {//在斐波那契中找到一个比arr数组长度大的数字作为新copy数组的长度
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < f[k]; i++) {//将新数组后面补0的元素都替换成原数组的最后一个值
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;//找到mid值
            if (key < temp[mid]) {//左边递归
                high = mid - 1;
                k--;//f[k]=f[k-1]+f[k-2],前面有k-1个元素,f[k-1]=f[k-2]+f[k-3],相差1
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;//后面有k-2个元素,f[k]=f[k-1]-1,k-1个元素时候就是k-2
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
