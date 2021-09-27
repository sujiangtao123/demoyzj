package com.company.Test.tree.leadBinary;

public class LeadBinaryTree {
    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "1");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node6 = new HeroNode(6, "6");
        HeroNode node8 = new HeroNode(8, "8");
        HeroNode node10 = new HeroNode(10, "10");
        HeroNode node14 = new HeroNode(14, "14");
        node1.setLeft(node3);
        node1.setRight(node6);
        node3.setLeft(node8);
        node3.setRight(node10);
        node6.setLeft(node14);
        LeadBinaryTreeDemo leadBinaryTreeDemo = new LeadBinaryTreeDemo();
        leadBinaryTreeDemo.setRoot(node1);
        leadBinaryTreeDemo.threadTree(leadBinaryTreeDemo.getRoot());
        leadBinaryTreeDemo.threadList();

    }

}

class LeadBinaryTreeDemo {
    private HeroNode root;
    private HeroNode pre;//当前结点的前一个结点,前驱结点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return this.root;
    }

    public void threadTree(HeroNode heroNode) {
        if (heroNode == null) {
            return;
        }
        threadTree(heroNode.getLeft());//先线索化左子树
        //线索化当前结点
        if (heroNode.getLeft() == null) {//处理前驱结点
            heroNode.setLeft(pre);
            heroNode.setLeftType(1);
        }
        //当node移动到下一个的时候，再去处理当前结点的后继结点,此时pre就是当前结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(heroNode);
            pre.setRightType(1);
        }
        pre = heroNode;//每次都将当前结点后移
        threadTree(heroNode.getRight());//线索化右子树
    }

    public void threadList() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {//左子树
                node = node.getLeft();
            }
            System.out.println(node);
            //当前结点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}

//创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private int leftType;//为0代表当前结点的左边是左子树，为1代表是前驱结点
    private int rightType;//为0代表当前结点的右边是左子树，为1代表是后继结点

    public HeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
