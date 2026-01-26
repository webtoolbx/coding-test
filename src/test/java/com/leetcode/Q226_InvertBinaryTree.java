package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q226_InvertBinaryTree {

    @Test
    void test() {
        // Case 1: [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        TreeNode result1 = invertTree(root1);
        Assertions.assertEquals(4, result1.val);
        Assertions.assertEquals(7, result1.left.val);
        Assertions.assertEquals(2, result1.right.val);
        Assertions.assertEquals(9, result1.left.left.val);
        Assertions.assertEquals(6, result1.left.right.val);
        Assertions.assertEquals(3, result1.right.left.val);
        Assertions.assertEquals(1, result1.right.right.val);

        // Case 2: [2,1,3] -> [2,3,1]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        TreeNode result2 = invertTree(root2);
        Assertions.assertEquals(2, result2.val);
        Assertions.assertEquals(3, result2.left.val);
        Assertions.assertEquals(1, result2.right.val);

        // Case 3: []
        Assertions.assertNull(invertTree(null));
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
