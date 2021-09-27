package com.company.Test.stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.pop();
        arrayStack.List();

    }
}

class ArrayStack {
    private int maxSize;//栈的最大大小
    private int[] stack;
    private int top = -1;//默认一开始的栈顶元素

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //判断栈是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //往栈中添加元素
    public void push(int num) {
        if (isFull()) {
            System.out.printf("栈已满~~~\n");
            return;
        }
        stack[++top] = num;
    }

    //取出栈顶元素
    public void pop() {
        if (isEmpty()) {
            System.out.printf("栈为空~~~\n");
            return;
        }
        int value = stack[top];
        --top;
        System.out.printf("取出栈顶元素%d\n", value);
    }

    //显示栈的元素,需要从栈顶遍历
    public void List() {
        if (isEmpty()) {
            System.out.printf("栈为空~~~\n");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈中元素%d\n", stack[i]);
        }
    }
}
