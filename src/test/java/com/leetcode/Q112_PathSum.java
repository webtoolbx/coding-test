package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q112_PathSum {

    @Test
    void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Assertions.assertTrue(hasPathSum(root, 22));
        Assertions.assertFalse(hasPathSum(root, 26));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // 현재 노드가 리프 노드이고, 남은 targetSum이 현재 노드 값과 같다면 성공!
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 왼쪽이나 오른쪽 중 하나라도 true를 반환하면 true 리턴 (Short-circuit)
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
