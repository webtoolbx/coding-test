package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q100_SameTree {

    @Test
    void test() {
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assertions.assertTrue(isSameTree(p1, q1));

        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        Assertions.assertFalse(isSameTree(p2, q2));

        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        Assertions.assertFalse(isSameTree(p3, q3));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // DFS
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
