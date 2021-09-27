package com.company.Test.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 7, 9, 15, 26, 0};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void QuickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l, right = r;
        int mid = arr[right];
        while (left < right) {
            while (left < right && arr[left] <= mid) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            while (left < right && arr[right] >= mid) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            if (left == right) {
                arr[left] = mid;
            }
        }
        QuickSort(arr, l, right - 1);
        QuickSort(arr, right + 1, r);
    }
}
