package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q102 {


    // 테스트 코드
    @Test
    void testLevelOrder() {
        // Case 1: 일반적인 트리
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> expected = List.of(
            List.of(3),
            List.of(9, 20),
            List.of(15, 7)
        );

        Assertions.assertEquals(expected, levelOrder(root));

        // Case 2: 루트만 있는 경우
        Assertions.assertEquals(List.of(List.of(1)), levelOrder(new TreeNode(1)));

        // Case 3: 빈 트리
        Assertions.assertEquals(List.of(), levelOrder(null));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode node, int height, List<List<Integer>> list){
        if(list.size() != height){
            list.get(height).add(node.val);
        } else {
            list.add(new ArrayList<>(List.of(node.val)));
        }

        if(node.left != null){
            dfs(node.left, height+1, list);
        }
        if(node.right != null){
            dfs(node.right, height+1, list);
        }
    }
}
