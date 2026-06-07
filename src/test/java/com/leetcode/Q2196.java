package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2196 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                   Objects.equals(left, treeNode.left) &&
                   Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    @Test
    void test() {
        // This test seems unrelated to Q2196, it's for romanToInt.
        // I'll remove it to avoid confusion.
        // Assertions.assertEquals(3, romanToInt("III"));
        // Assertions.assertEquals(58, romanToInt("LVIII"));
        // Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    @Test
    void testCreateBinaryTree() {
        Q2196 solution = new Q2196();

        // Test case 1: Example from LeetCode
        int[][] descriptions1 = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode expected1 = new TreeNode(50,
                                new TreeNode(20,
                                    new TreeNode(15),
                                    new TreeNode(17)),
                                new TreeNode(80,
                                    new TreeNode(19),
                                    null));
        TreeNode result1 = solution.createBinaryTree(descriptions1);
        Assertions.assertEquals(expected1, result1);

        // Test case 2: Single node tree
        int[][] descriptions2 = {{1,2,1}};
        TreeNode expected2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode result2 = solution.createBinaryTree(descriptions2);
        Assertions.assertEquals(expected2, result2);

        // Test case 3: More complex tree
        int[][] descriptions3 = {{1,2,1},{1,3,0},{2,4,1},{2,5,0},{3,6,1},{3,7,0}};
        TreeNode expected3 = new TreeNode(1,
                                new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                                new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
        TreeNode result3 = solution.createBinaryTree(descriptions3);
        Assertions.assertEquals(expected3, result3);

        // Test case 4: Root is a child of another node, but that node is not a child of anything
        int[][] descriptions4 = {{10,20,1}, {20,30,1}};
        TreeNode expected4 = new TreeNode(10, new TreeNode(20, new TreeNode(30), null), null);
        TreeNode result4 = solution.createBinaryTree(descriptions4);
        Assertions.assertEquals(expected4, result4);

        // Test case 5: Empty descriptions
        int[][] descriptions5 = {};
        TreeNode expected5 = null;
        TreeNode result5 = solution.createBinaryTree(descriptions5);
        Assertions.assertEquals(expected5, result5);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        // parent, child, isLeft
        // make the tree and return root node
        // key: parent, value: Node
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        for (int[] info : descriptions) {
            int p = info[0];
            int c = info[1];
            boolean left = info[2] == 1;

            map.putIfAbsent(p, new TreeNode(p));
            map.putIfAbsent(c, new TreeNode(c));

            TreeNode parent = map.get(p);
            TreeNode child = map.get(c);

            if(left){
                parent.left = child;
            } else {
                parent.right = child;
            }
            childSet.add(c);
        }

        for(int key : map.keySet()){
            if(!childSet.contains(key)){
                return map.get(key);
            }
        }

        return null;
    }
}
