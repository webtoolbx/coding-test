package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q222_CountCompleteTreeNodes {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        Assertions.assertEquals(6, countNodes(root));
        Assertions.assertEquals(0, countNodes(null));
        Assertions.assertEquals(1, countNodes(new TreeNode(1)));
    }

    public int countNodes(TreeNode root) {
        // 왼쪽으로 내려가서 높이 체크
        // 같은 높이에 몇 개 있는지 체크

        int left = getHeight(root, true);
        int right = getHeight(root, false);

        // 좌우가 동일하면 높이만큼 더하기
        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int getHeight(TreeNode node, boolean leftSide) {
        int height = 0;
        while (node != null) {
            height++;
            if (leftSide) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return height;
    }

    // public int countNodes(TreeNode root) {
    //     ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    //     //BFS
    //     int cnt = 0;

    //     if(root != null){
    //         queue.add(root);
    //         while(!queue.isEmpty()){
    //             cnt++;
    //             TreeNode node = queue.poll();
    //             if(node.left != null){
    //                 queue.add(node.left);
    //             }
    //             if(node.right != null){
    //                 queue.add(node.right);
    //             }
    //         }
    //     }
    //     return cnt;
    // }
}
