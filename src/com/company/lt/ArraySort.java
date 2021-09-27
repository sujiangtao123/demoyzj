package com.company.lt;

import com.company.model.User;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class ArraySort {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(3);
        ListNode head6 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
//        System.out.println(head1);
//        System.out.println(deleteDuplicates(head1));
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        root.left = null;
        root.right = treeNode;
        treeNode.left = treeNode1;
        treeNode.right = null;
//        System.out.println(isSameTree(root, root));
//        System.out.println(sortedArrayToBST(new int[]{1, 2, 3, 4, 5}).toString());
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(3);
        root2.left = root1;
//        root2.right = root3;
        root2.left.left = root3;
//        root3.right = root4;
//        root4.left = root5;
        System.out.println(isBalanced(root2));
    }


    //两个有序数组合并,从小到大排序
    @Test
    public void test1() {
        int[] num1 = {1, 2, 3, 0, 0};
        int[] num2 = {4, 5};
        int i = 2; //m -1
        int j = 1; //n -1
        int k = 4; //m+n-1
        while (i >= 0 && j >= 0) {
            if (num1[i] > num2[j])
                num1[k--] = num1[i--];
            else
                num1[k--] = num2[j--];
        }
        //i>0就是num1中元素本身就是有序的, j >0,
        while (j >= 0) {
            num1[k--] = num1[j--];
        }
        System.out.println(Arrays.toString(num1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void merge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        // 倒着遍历比较
        int m = 3;
        int n = 3;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];

        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        root.left = null;
        root.right = treeNode;
        treeNode.left = treeNode1;
        treeNode.right = null;
        List<Integer> list = new LinkedList<>();
        infixOrder(root, list);
        System.out.println(list);
    }

    public void infixOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        infixOrder(root.left, res);
        res.add(root.val);
        infixOrder(root.right, res);
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(p);
        treeNodes.offer(q);
        while (!treeNodes.isEmpty()) {
            p = treeNodes.poll();
            q = treeNodes.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            treeNodes.offer(p.left);
            treeNodes.offer(q.right);

            treeNodes.offer(p.right);
            treeNodes.add(q.left);
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int m = 0;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode poll = treeNodes.poll();
                if (poll.left != null) {
                    treeNodes.offer(poll.left);
                }
                if (poll.right != null) {
                    treeNodes.offer(poll.right);
                }
                size--;
            }
            m++;
        }
        return m;
    }

    //最小深度最先找到叶子节点的就是最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int level = 1;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode poll = treeNodes.poll();
                if (poll.left == null && poll.right == null) {
                    return level;
                }
                if (poll.left != null) {
                    treeNodes.offer(poll.left);
                }
                if (poll.right != null) {
                    treeNodes.offer(poll.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
