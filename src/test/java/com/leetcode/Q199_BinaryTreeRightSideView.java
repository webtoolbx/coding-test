package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q199_BinaryTreeRightSideView {

    @Test
    void test() {
        // Case 1: [1,2,3,null,5,null,4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        Assertions.assertEquals(List.of(1, 3, 4), rightSideView(root1));

        // Case 2: [1,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        Assertions.assertEquals(List.of(1, 3), rightSideView(root2));

        // Case 3: []
        Assertions.assertEquals(List.of(), rightSideView(null));
    }

    public List<Integer> rightSideView(TreeNode root) {
        // BFS 가장 오른쪽
        List<Integer> ans = new ArrayList<>();

        if(root == null) return new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode right = list.get(list.size()-1);
            ans.add(right.val);

            List<TreeNode> newList = new ArrayList<>();
            for(TreeNode node : list){
                if(node.left != null){
                    newList.add(node.left);
                }
                if(node.right != null){
                    newList.add(node.right);
                }
            }
            list = newList;
        }

        return ans;
    }
}
