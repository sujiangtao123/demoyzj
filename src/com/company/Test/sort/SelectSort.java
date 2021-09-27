package com.company.Test.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {101,34,119,1};
//        int[] array = {1,34,101,119};

        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i; //设定最小值是数组第一个
            int min = array[i]; //拿到最小值
            //比较后面的值
            for (int j = i+1; j < array.length; j++) {
                if(min > array[j]){
                    min = array[j]; //重置最小值
                    minIndex = j; //重置最小值小标
                }
            }
            //交换位置和第一个
            if(minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
            System.out.println("第"+(i+1)+"轮交换: "+Arrays.toString(array));

        }
        System.out.println(Arrays.toString(array));

    }
}
