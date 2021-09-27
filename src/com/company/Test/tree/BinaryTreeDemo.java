package com.company.Test.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊");
        HeroNode node4 = new HeroNode(4, "林冲");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(node1);
        binaryTree.preOrder();
        binaryTree.delNode(2);
        binaryTree.preOrder();
//        System.out.println(binaryTree.postOrderSearch(2));
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {//前序遍历
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {//中序遍历
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder() {//后序遍历
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode preOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
        return heroNode;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
        return heroNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.root != null) {
            heroNode = this.root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
        return heroNode;
    }

    public void delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空，无法删除");
        }
    }
}

//创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public void preOrder() {//前序遍历
        System.out.println(this);
        if (this.left != null) {//递归向左子树前序遍历
            this.left.preOrder();
        }
        if (this.right != null) {//递归向右子树前序遍历
            this.right.preOrder();
        }
    }

    public void infixOrder() {//中序遍历
        if (this.left != null) {//递归向左子树中序遍历
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {//递归向右子树中序遍历
            this.right.infixOrder();
        }
    }

    public void postOrder() {//后序遍历
        if (this.left != null) {//递归向左子树后序遍历
            this.left.preOrder();
        }
        if (this.right != null) {//递归向右子树后序遍历
            this.right.preOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderSearch(int no) {//前序查找
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {//说明左边递归找到了
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    public HeroNode infixOrderSearch(int no) {//中序查找
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {//说明左边递归找到了
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    public HeroNode postOrderSearch(int no) {//后序查找
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {//说明左边递归找到了
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        if (heroNode != null) {//说明右边递归找到了
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {//在左边找到
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {//在右边找到
            this.right = null;
            return;
        }
        if (this.left != null) {//向左边递归
            this.left.delNode(no);
        }
        if (this.right != null) {//向右边递归
            this.right.delNode(no);
        }
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}