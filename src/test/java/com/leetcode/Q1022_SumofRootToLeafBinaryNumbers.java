package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1022_SumofRootToLeafBinaryNumbers {

    @Test
    void test() {
        TreeNode root1 = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        Assertions.assertEquals(22, sumRootToLeaf(root1));

        TreeNode root2 = new TreeNode(0);
        Assertions.assertEquals(0, sumRootToLeaf(root2));
    }

    public int sumRootToLeaf(TreeNode root) {
        List<Node> list = new ArrayList<>();

        Node node = new Node(String.valueOf(root.val), root);
        list.add(node);

        int answer = 0;
        while(!list.isEmpty()){
            List<Node> newList = new ArrayList<>();
            for(Node n : list){
                if(n.node.left != null){
                    newList.add(new Node(n.s + n.node.left.val, n.node.left));
                }
                if(n.node.right != null){
                    newList.add(new Node(n.s + n.node.right.val, n.node.right));
                }

                if(n.node.left == null && n.node.right == null){
                    // System.out.println(n.s);
                    // System.out.println(Integer.parseInt(n.s, 2));
                    answer += Integer.parseInt(n.s, 2);
                }
            }

            list = newList;
        }




        return answer;
    }

    public class Node {
        public String s;
        TreeNode node;

        public Node(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }
}
