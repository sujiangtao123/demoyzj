package com.company.Test.avl;


import java.util.HashMap;

public class AvlTree {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlTreeDemo avlTreeDemo = new AvlTreeDemo();
        for (int value : arr) {
            avlTreeDemo.add(new Node(value));
        }
        System.out.println(avlTreeDemo.getRoot().height());
        System.out.println(avlTreeDemo.getRoot().leftHeight());
        System.out.println(avlTreeDemo.getRoot().rightHeight());
        System.out.println(avlTreeDemo.getRoot());
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}

class AvlTreeDemo {
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

    //左子树高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //右子树高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //计算数的高度
    public int height() {
        int leftValue = (left == null ? 0 : left.height());
        int rightValue = (right == null ? 0 : right.height());
        int i = Math.max(leftValue, rightValue) + 1;
        return i;
    }

    //二叉树左旋转方法
    public void leftRotate() {
        Node newNode = new Node(value); //以当前结点为值创建新的节点
        newNode.left = this.left; //新节点的左子树设置为当前结点的左子树
        newNode.right = this.right.left; //新结点的右子树设置为当前结点的右子树的左子树
        value = this.right.value; //把当前结点换成右子结点的值
        this.right = this.right.right; //把当前结点的右子树设置为当前结点的右子树的右子树
        this.left = newNode; //把当前结点的左子结点设置为新的结点
    }

    //二叉树右旋转方法
    public void rightRotate() {
        Node newNode = new Node(value); //以当前结点为值创建新的节点
        newNode.right = this.right; //新节点的右子树设置为当前结点的右子树
        newNode.left = this.left.right; //新结点的左子树设置为当前结点的左子树的右子树
        value = this.left.value; //把当前结点值换成左子结点的值
        this.left = this.left.left; //把当前结点的左子树设置为当前结点的左子树的左子树
        this.right = newNode; //把当前结点的右子结点设置为新的结点
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
        if (rightHeight() - leftHeight() > 1) {
            if (right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        if (leftHeight() - rightHeight() > 1) {
            if (left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
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
