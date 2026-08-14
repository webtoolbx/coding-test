package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q230 {

    @Test
    void test() {
    }

    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        // 중위 순회?
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k){
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if(count == k){
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
