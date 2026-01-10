package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1161_MaximumLevelSumofaBinaryTree {

    @Test
    void test() {
        TreeNode root1 = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        Assertions.assertEquals(2, maxLevelSum(root1));

        TreeNode root2 = new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))));
        Assertions.assertEquals(2, maxLevelSum(root2));
    }

    public int maxLevelSum(TreeNode root) {
        // BFS 잖아
        int max = Integer.MIN_VALUE;
        int ans = 1;
        List<TreeNode> list = new ArrayList<>();

        list.add(root);
        int idx = 1;
        while(!list.isEmpty()){
            List<TreeNode> nextList = new ArrayList<>();
            int sum = 0;
            for(TreeNode node : list){
                sum += node.val;
                if(node.left != null){
                    nextList.add(node.left);
                }
                if(node.right != null){
                    nextList.add(node.right);
                }
            }
            if(sum > max){
                ans = idx;
                max = sum;
            }
            idx++;
            list = nextList;
        }

        return ans;
    }
}
