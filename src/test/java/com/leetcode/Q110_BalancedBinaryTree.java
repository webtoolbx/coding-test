package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q110_BalancedBinaryTree {

    @Test
    void test() {
        Q110_BalancedBinaryTree solution = new Q110_BalancedBinaryTree();

        // Case 1: [3,9,20,null,null,15,7] -> true
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        Assertions.assertTrue(solution.isBalanced(root1));

        // Case 2: [1,2,2,3,3,null,null,4,4] -> false
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        Assertions.assertFalse(solution.isBalanced(root2));

        // Case 3: [] -> true
        Assertions.assertTrue(solution.isBalanced(null));
    }

    public boolean isBalanced(TreeNode root) {
        // 높이 맞추기
        // 한 개 이상 차이 나면 안됨
        // 반복이니까 DFS 로 푸는게 나을 수 있음
        return DFS(root, 1) != -1;
    }

    // 이런 느낌으로 반복되어야함
    public int DFS(TreeNode node, int step){
        if(node == null) return step;

        int left = DFS(node.left, step + 1);
        if (left == -1) return -1; // Pruning if left is already unbalanced

        int right = DFS(node.right, step + 1);
        if (right == -1) return -1; // Pruning if right is already unbalanced

        // System.out.println("left : " + left + " right : " + right);

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right);
    }
}
