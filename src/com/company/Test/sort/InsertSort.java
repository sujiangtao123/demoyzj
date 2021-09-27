package com.company.Test.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {101,34,12,23};
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < array.length; i++) {
            //将第二个元素和前面的元素比较
             insertValue = array[i];
            //前一个元素的下标
             insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                //如果前面的元素比自己小，就将前面的元素后移
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            //退出循环找到要插入的位置insertIndex+1
            array[insertIndex + 1] = insertValue;
        }
        System.out.println(Arrays.toString(array));
    }
}
