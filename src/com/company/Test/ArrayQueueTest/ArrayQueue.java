package com.company.Test.ArrayQueueTest;

import java.util.Scanner;

public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(3);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean lock = true;
        while (lock) {
            System.out.println("输入a添加数据");
            System.out.println("输入g取出数据");
            System.out.println("输入s查看数据");
            System.out.println("输入h获取头数据");
            System.out.println("输入e退出数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输出一个数据");
                    int value = scanner.nextInt();
                    arrayQueueDemo.addQueue(value);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueueDemo.getQueue();
                        System.out.printf("已经取出数据%d\n", queue);
                    } catch (Exception e) {
                        System.out.println("异常");
                    }
                    break;
                case 's':
                    arrayQueueDemo.showQueue();
                    break;
                case 'h':
                    try {
                        int i = arrayQueueDemo.headQueue();
                        System.out.printf("已经取出头部数据%d\n", i);
                    } catch (Exception e) {
                        System.out.println("异常head");
                    }
                    break;
                case 'e':
                    scanner.close();
                    lock = false;
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

class ArrayQueueDemo {
    private int front;
    private int rear;
    private int[] array;
    private int maxSize;

    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = -1;//队头前一个位置
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int m) {
        if (isFull()) {
            System.out.println("队列已满,不能添加");
        } else {
            array[++rear] = m;
        }

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取");
        }
        return array[++front];

    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,不能取");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取");
        }
        return array[++front];
    }

}
