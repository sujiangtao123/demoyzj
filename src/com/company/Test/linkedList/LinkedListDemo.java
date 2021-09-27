package com.company.Test.linkedList;

import java.util.Stack;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedListTest linkedListTest = new LinkedListTest();
        HeroNode heroNode1 = new HeroNode(1, "猫", "cat");
        HeroNode heroNode2 = new HeroNode(2, "狗", "dog");
        HeroNode heroNode3 = new HeroNode(3, "猪", "pig");
//        linkedListTest.addLinkedList(heroNode1);
//        linkedListTest.addLinkedList(heroNode2);
//        linkedListTest.addLinkedList(heroNode3);
        linkedListTest.addByOrder(heroNode1);
        linkedListTest.addByOrder(heroNode3);
        linkedListTest.addByOrder(heroNode2);
//        linkedListTest.delete(1);
        linkedListTest.getLinkedList();
//        System.out.println(getLength(linkedListTest.getHeroNode()));
//        System.out.println(findLastIndexNode(linkedListTest.getHeroNode(), 1));
//        reverseLink(linkedListTest.getHeroNode());
        getReverseList(linkedListTest.getHeroNode());
    }

    //查找有效节点个数
    public static int getLength(HeroNode node) {
        int length = 0;
        if (node.next == null) {
            return 0;
        }

        HeroNode cur = node.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;

    }

    //查找单链表中倒数第K个节点,遍历(有效长度-index)个元素就可以了
    public static HeroNode findLastIndexNode(HeroNode node, int index) {
        if (node.next == null) {
            return null;
        }
        int length = getLength(node);
        if (index < 0 || index > length) {
            return null;
        }
        int m = length - index;
        HeroNode cur = node.next;
        for (int i = 0; i < m; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //链表翻转
    public static void reverseLink(HeroNode node) {
        if (node.next == null || node.next.next == null) {
            return;
        }
        HeroNode cur = node.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, ",", "");
        while (cur != null) {
            next = cur.next; //当前节点的下一个节点
            cur.next = reverseHead.next; //当前节点的指针指向新的翻转链表的最前端
            reverseHead.next = cur; //新链表头结点指向最前端节点
            cur = next; //指针后移动
        }
        node.next = reverseHead.next;
    }

    //从尾到头打印单链表
    public static void getReverseList(HeroNode node) {
        if (node.next == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = node.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

}

class LinkedListTest {
    //指定头结点不可动
    private HeroNode heroNode = new HeroNode(0, "", "");

    public HeroNode getHeroNode() {
        return heroNode;
    }

    //链表添加元素
    public void addLinkedList(HeroNode head) {
        //辅助节点
        HeroNode node = heroNode;
        while (true) {
            if (node.next == null) {//尾节点
                break;
            }
            //指针后移
            node = node.next;
        }
        node.next = head;
    }

    public void update(HeroNode head) {
        HeroNode temp = heroNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == head.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.heroName = head.heroName;
            temp.snickName = head.snickName;
        }

    }

    //删除节点
    public void delete(int no) {
        HeroNode temp = heroNode;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到了
            temp.next = temp.next.next;
        } else {
            System.out.println("没有删除的节点");
        }
    }

    //按照编号顺序添加
    public void addByOrder(HeroNode head) {
        //使用辅助节点
        HeroNode temp = heroNode;
        //用来判断是否是可添加的元素,编号是否存在，默认false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//表尾
                break;
            }
            if (temp.next.no > head.no) {//找到位置
                break;
            }
            if (temp.next.no == head.no) {//重复编号
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号【%d】重复\n", head.no);
        } else {
            //插入
            head.next = temp.next;
            temp.next = head;
        }
    }

    //显示遍历链表
    public void getLinkedList() {
        if (heroNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = heroNode.next;
        while (temp != null) {
            System.out.println(temp);
            //指针后移
            temp = temp.next;
        }

    }
}


class HeroNode {
    public int no;
    public String heroName;
    public String snickName;
    public HeroNode next;

    public HeroNode(int no, String heroName, String snickName) {
        this.no = no;
        this.heroName = heroName;
        this.snickName = snickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", heroName='" + heroName + '\'' +
                ", snickName='" + snickName + '\'' +
                '}';
    }
}
