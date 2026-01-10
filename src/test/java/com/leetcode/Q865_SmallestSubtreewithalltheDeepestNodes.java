package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q865_SmallestSubtreewithalltheDeepestNodes {

    @Test
    void test() {
        // Case 1: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode result1 = subtreeWithAllDeepest(root1);
        Assertions.assertEquals(2, result1.val);

        // Case 2: [1]
        TreeNode root2 = new TreeNode(1);
        TreeNode result2 = subtreeWithAllDeepest(root2);
        Assertions.assertEquals(1, result2.val);

        // Case 3: [0,1,3,null,2]
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(2);

        TreeNode result3 = subtreeWithAllDeepest(root3);
        Assertions.assertEquals(2, result3.val);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 왼쪽 오른쪽을 DFS로 진행하면서
        // 가장 깊은 숫자는 기록해두기
        Info info = DFS(root, 1);
        return info.getNode();
    }

    private Info DFS(TreeNode node, int depth){
        Info left = null;
        if(node.left != null){
            left = DFS(node.left, depth+1);
        }
        Info right = null;
        if(node.right != null){
            right = DFS(node.right, depth+1);
        }
        if(left != null && right != null){
            if(left.getDepth() == right.getDepth()){
                return new Info(left.getDepth(), node);
            } else if(left.getDepth() > right.getDepth()){
                return new Info(left.getDepth(), left.getNode());
            } else {
                return new Info(right.getDepth(), right.getNode());
            }
        } else if(left != null){
            return new Info(left.getDepth(), left.getNode());
        } else if(right != null){
            return new Info(right.getDepth(), right.getNode());
        }

        return new Info(depth, node);
    }

    public class Info{
        private int depth;
        private TreeNode node;

        public Info(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }

        public int getDepth(){
            return depth;
        }

        public TreeNode getNode(){
            return node;
        }
    }
}
