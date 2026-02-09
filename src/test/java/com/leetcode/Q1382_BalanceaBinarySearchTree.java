package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1382_BalanceaBinarySearchTree {

    @Test
    void test() {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode balanced1 = balanceBST(root1);
        Assertions.assertTrue(isBalanced(balanced1));
        Assertions.assertTrue(isValidBST(balanced1));

        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode balanced2 = balanceBST(root2);
        Assertions.assertTrue(isBalanced(balanced2));
        Assertions.assertTrue(isValidBST(balanced2));
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        // 모든 값을 순회하고 정렬한뒤 중간 값을 root 로 값 넣어주기?
        list.clear(); // Clear list for multiple test runs
        inOrder(root);

        return buildBalancedTree(0, list.size()-1);
    }

    // 중위 순회로 모든 값 입력
    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }

    private TreeNode buildBalancedTree(int start, int end){
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = list.get(mid);

        node.left = buildBalancedTree(start, mid-1);
        node.right = buildBalancedTree(mid+1, end);

        return node;
    }
}
