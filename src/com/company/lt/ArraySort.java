package com.company.lt;

import com.company.model.User;
import org.junit.Test;

import java.net.NetworkInterface;
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
        root2.right = root4;
//        root2.left.left = root3;
//        root3.right = root4;
        root4.left = root5;
//        System.out.println(isBalanced(root2));
//        System.out.println(hasPathSum(root2, 6));
//        System.out.println(generate(5));
//        System.out.println(getRow(3));
//        System.out.println(maxProfit(new int[]{10, 5, 20, 1, 4}));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
//        System.out.println(preorderTraversal(root2));
//        System.out.println(postorderTraversal(root2));
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
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

    //二叉树路径之和
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode poll = treeNodes.poll();
            if (poll.left == null && poll.right == null) {
                if (poll.val == sum) {
                    return true;
                }
                continue;
            }
            if (poll.left != null) {
                treeNodes.offer(poll.left);
                poll.left.val = poll.val + poll.left.val;
            }
            if (poll.right != null) {
                treeNodes.offer(poll.right);
                poll.right.val = poll.val + poll.right.val;
            }
        }
        return false;
    }

    //杨辉三角
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> ros = new ArrayList<>();
            for (int j = 0; j <= i - 1; j++) {
                //如果是每行的头和尾,直接为1
                if (j == 0 || j == i - 1) {
                    ros.add(1);
                } else {
                    ros.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }
            }
            list.add(ros);
        }
        return list;
    }

    //杨辉三角II 给定一个非负索引rowIndex,返回rowIndex行
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //如果是每行的头和尾,直接为1
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }

    //股票最佳时机算法 lc 121题
    public static int maxProfit(int[] prices) {
        int difference = 0;
        int maxPrice = Integer.MAX_VALUE;
        if (prices.length == 0) {
            return 0;
        }
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > difference) {
//                    difference = prices[j] - prices[i];
//                }
//            }
//        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < maxPrice) {
                maxPrice = prices[i];
            } else if (prices[i] - maxPrice > difference) {
                difference = prices[i] - maxPrice;
            }
        }
        return difference;
    }

    // 验证回文串 lc 125题
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            String s1 = String.valueOf(s.charAt(left));
            String s2 = String.valueOf(s.charAt(right));
            boolean b = String.valueOf(s1).equalsIgnoreCase(s2);
            if (!b) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //找出只出现一次的数字 lc 136
    public static int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.putIfAbsent(nums[i], 1);
//            } else {
//                int m = map.get(nums[i]);
//                map.put(nums[i], ++m);
//            }
//        }
//       return map.entrySet().stream().filter(entry->entry.getValue() == 1)
//               .map(Map.Entry::getKey).collect(Collectors.toList()).get(0);
        //进阶版
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    //判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 前序遍历二叉树 lc 144题
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return preOrder(root, list);
    }

    public static List<Integer> preOrder(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            preOrder(root.left, list);
        }
        if (root.right != null) {
            preOrder(root.right, list);
        }
        return list;
    }

    // 二叉树后续遍历 lc 145题
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return postOrder(root, list);
    }

    public static List<Integer> postOrder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            postOrder(root.left, list);
        }
        if (root.right != null) {
            postOrder(root.right, list);
        }
        list.add(root.val);
        return list;
    }

    // 相交链表算法 lc 160题目
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : pb;
            pb = pb != null ? pb.next : pa;
        }
        return pa;
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

// 最小栈 lc 155题目
class MinStack {
    //数组里是[当前值,最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
