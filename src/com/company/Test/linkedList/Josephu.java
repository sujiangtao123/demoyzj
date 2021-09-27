package com.company.Test.linkedList;

public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();
        list.getCount(1,2,5);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    //构建环形单向链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("至少添加一个编号");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //添加的boy节点
            Boy boy = new Boy(i);
            if (i == 1) {
                //第一个节点自己指向自己
                first = boy;
                first.next = boy;
                //指针后移
                curBoy = first;
            } else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy boy = first;//辅助指针
        while (true) {
            System.out.println(boy.getNo());
            if (boy.next == first) {
                break;
            }
            boy = boy.next;
        }
    }

    //圈出数到的小孩出队startNo:从第几个开始数 count: 数几个出圈 maxNo：圈内的小孩
    public void getCount(int startNo, int count, int maxNo) {
        if (first == null || startNo < 1 || startNo > maxNo || count > maxNo) {
            System.out.println("参数不合法");
            return;
        }
        Boy boy = first;
        Boy helper = null;
        //找到最后一个节点指针
        while (true) {
            if (boy.next == first) {
                break;
            }
            boy = boy.next;
        }
        //最后一个节点
        helper = boy;
        //将first指针指向开始报数的第K个位置,移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        //将first和helper指针移动count-1次，这就是此时出圈的小孩,这里是循环操作
        while (true) {
            //圈内只剩下自己
            if (helper == first) {
                break;
            }
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            //first节点就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.next;
            helper.next = first;
        }
        System.out.printf("剩余圈内小孩%d", helper.getNo());
    }

}

class Boy {
    private int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
