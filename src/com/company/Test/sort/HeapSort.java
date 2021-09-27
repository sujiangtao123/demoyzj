package com.company.Test.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        //将无序数列构建成一个堆，按照排序顺序选择是大顶堆还是小顶堆
        //arr.length /2-1 最后一个非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adJustHeap(arr, i, arr.length);
        }
        //堆顶元素与末尾元素交换，最大元素到数组末端，反复执行
        for (int j = arr.length - 1; j > 0; j--) {
            arr[0] ^= arr[j];
            arr[j] = arr[0] ^ arr[j];
            arr[0] = arr[0] ^ arr[j];
            adJustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr    数组元素
     * @param i      表示非叶子节点在数组中的索引下标
     * @param length 数组长度
     *               大顶堆调整
     */
    private static void adJustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先保存当前值
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {//调整左子树
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;//如果左节点小于右结点，就指向右结点,先对左右结点进行比较
            }
            if (arr[k] > temp) {//子树结点还是大于父节点就交换
                arr[i] = arr[k];
                i = k;//赋值下标,继续循环
            } else {
                break;
            }
        }
        //退出for循环就调整完成,将父节点值赋给左/右子树
        arr[i] = temp;
    }
}
