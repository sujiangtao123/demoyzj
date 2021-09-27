package com.company.Test.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8, 5, 2, 1, 4, 7, 3, 6, 9, 0};
        //增量gap，并逐步的缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，直接对其多在的组进行插入排序
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                while (j - gap >= 0 && temp < array[j - gap]) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
