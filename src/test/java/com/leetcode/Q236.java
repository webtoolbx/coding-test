package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q236 {

    // 3. 실행 가능한 테스트 메소드
    @Test
    void test() {
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 최소 공통 조상 찾기

        // 하나는 왼쪽에
        // 다른 하나는 오른쪽에 있으면 현재 값이 답
        // 본인이 부모일수도 있구나
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }
}
