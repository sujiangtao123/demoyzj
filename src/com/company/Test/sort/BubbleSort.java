package com.company.Test.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        //从小到大排序
        int[] arr = {3, 9, -1, 10, -2};

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //这里防止顺序拍好以后还继续排序
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //如果没有发生交换说明是已经排好序了
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
            System.out.println("第"+(i+1)+"躺: "+Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
    }
}
