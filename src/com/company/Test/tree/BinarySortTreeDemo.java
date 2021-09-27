package com.company.Test.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySort binarySort = new BinarySort();
        for (int value : arr) {
            binarySort.add(new Node(value));
        }
        binarySort.delNode(2);
        binarySort.delNode(5);
        binarySort.delNode(9);
        binarySort.delNode(12);
        binarySort.delNode(7);
        binarySort.delNode(3);
        binarySort.delNode(10);
//        binarySort.delNode(1);
        System.out.println("root= "+binarySort.getRoot());
        binarySort.infixOrder();
    }
}

class BinarySort {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        //退出while循环右子树的最小值就找到了,删除这个最小值
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {//判断删除的结点是不是没有父节点
                root = null;
                return;
            }
            Node parentNode = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {//如果删除的是叶子节点
                if (parentNode.left != null && parentNode.left.value == value) {//删除结点在父节点的左边
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//有两颗子树
                //找待删除结点右子树的最小结点
                int temp = delRightTreeMin(targetNode.right);
                targetNode.value = temp;

            } else {//有一颗子树
                if (targetNode.left != null) {//如果这颗子树是在删除结点的左边
                    if (parentNode != null) {
                        if (parentNode.left == targetNode) {//如果目标结点在父节点的左边
                            parentNode.left = targetNode.left;
                        } else {//如果目标结点在父节点的右边
                            parentNode.right = targetNode.left;
                        }
                    } else {//删除结点是根节点
                        root = targetNode.left;
                    }

                } else {//如果这颗子树是在删除结点的右边
                    if (parentNode != null) {
                        if (parentNode.left == targetNode) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }

                }
            }
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找要删除的结点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);//左边递归查找
            }
        } else {
            if (this.right != null) {
                return this.right.search(value);//右边边递归查找
            }
        }
        return null;
    }

    //查找删除结点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                this.right != null && this.right.value == value) {
            return this;
        } else if (value < this.value && this.left != null) {//左边递归查找
            return this.left.searchParent(value);
        } else if (value >= this.value && this.right != null) {//右边递归查找
            return this.right.searchParent(value);
        }
        return null;
    }

    //二叉排序树插入
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
        if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历二叉排序树
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}
