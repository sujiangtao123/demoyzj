package com.company.Test.ArrayQueueTest;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleQueue arrayQueueDemo = new CircleQueue(4);
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
//                case 'h':
//                    try {
//                        int i = arrayQueueDemo.headQueue();
//                        System.out.printf("已经取出头部数据%d\n", i);
//                    } catch (Exception e) {
//                        System.out.println("异常head");
//                    }
//                    break;
                case 'e':
                    scanner.close();
                    lock = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleQueue {
    private int front;
    private int rear;
    private int[] array;
    private int maxSize;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }


    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int m) {
        if (isFull()) {
            System.out.println("队列已满,不能添加");
        } else {
            array[rear] = m;
            //防止数组越界
            rear = (rear + 1) % maxSize;
        }

    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取");
        }
        int value = array[front];
        front = (front + 1) & maxSize;
        return value;

    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }
}
