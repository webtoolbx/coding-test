package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q104_MaximumDepthofBinaryTree {

    @Test
    void test() {
        // Case 1: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        Assertions.assertEquals(3, maxDepth1(root1));
        Assertions.assertEquals(3, maxDepth2(root1));

        // Case 2: [1,null,2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        Assertions.assertEquals(2, maxDepth1(root2));
        Assertions.assertEquals(2, maxDepth2(root2));
    }

    public int maxDepth1(TreeNode root) {
        return cal(root);
    }

    public int cal(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(cal(node.left), cal(node.right));
    }

    public int maxDepth2(TreeNode root) {
        // 어쨋든 모든 node 에 가본긴 해야함
        // 근데 메모리 측면에서 DFS가 좋긴 하겠네
        return DFS(root, 1);
    }

    public int DFS(TreeNode node, int depth){
        if(node == null) return 0;
        int left = DFS(node.left, depth+1);
        int right = DFS(node.right, depth+1);

        return Math.max(depth, Math.max(left, right));
    }
}
