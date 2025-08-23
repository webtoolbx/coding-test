package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q700_SearchinaBinarySearchTree {

    @Test
    void test() {
        int[] values = {4, 2, 7, 1, 3};
        BSTBuilder bstBuilder = new BSTBuilder();

        // BST 구축 시작
        bstBuilder.buildTree(values);
        ;
        System.out.println(searchBST(bstBuilder.getRoot(), 4).val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val){
                return root;
            } else if(root.val > val){
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
