package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q98 {

    @Test
    void test() {
    }

    boolean result = true;
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        // 중위 순회하면서 직전 값보다 큰지 확인
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);
        if(prev != null && prev >= node.val){;
            result = false;
            return;
        }
        prev = node.val;
        dfs(node.right);
    }
}
