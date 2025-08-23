package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q104_MaximumDepthofBinaryTree {

    @Test
    void test() {
        System.out.println("result : " + maxDepth(new TreeNode(1)));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return cal(root);
    }

    public int cal(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(cal(node.left), cal(node.right));
    }
}
