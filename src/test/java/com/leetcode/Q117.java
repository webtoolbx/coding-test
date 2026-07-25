package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q117 {

    // Definition for a Node.
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        // Helper method to convert the connected tree to a list of lists for easy assertion
        public List<List<Integer>> toLevelOrderList() {
            List<List<Integer>> result = new ArrayList<>();
            if (this == null) {
                return result;
            }

            Node leftmost = this;
            while (leftmost != null) {
                List<Integer> currentLevel = new ArrayList<>();
                Node current = leftmost;
                while (current != null) {
                    currentLevel.add(current.val);
                    current = current.next;
                }
                result.add(currentLevel);

                // Move to the next level's leftmost node
                if (leftmost.left != null) {
                    leftmost = leftmost.left;
                } else if (leftmost.right != null) {
                    leftmost = leftmost.right;
                } else {
                    // Find the leftmost child of any node in the current level
                    Node temp = leftmost;
                    Node nextLeftmost = null;
                    while (temp != null) {
                        if (temp.left != null) {
                            nextLeftmost = temp.left;
                            break;
                        }
                        if (temp.right != null) {
                            nextLeftmost = temp.right;
                            break;
                        }
                        temp = temp.next;
                    }
                    leftmost = nextLeftmost;
                }
            }
            return result;
        }
    }

    @Test
    void testConnect() {
        Q117 solution = new Q117();

        // Test case 1: Example from LeetCode
        // Input: root = [1,2,3,4,5,null,7]
        // Output: [1,#,2,3,#,4,5,7,#]
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.right = new Node(7);

        Node connectedRoot1 = solution.connect(root1);
        List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 7)
        );
        Assertions.assertEquals(expected1, connectedRoot1.toLevelOrderList());

        // Test case 2: Empty tree
        // Input: root = []
        // Output: []
        Node root2 = null;
        Node connectedRoot2 = solution.connect(root2);
        Assertions.assertNull(connectedRoot2);

        // Test case 3: Single node tree
        Node root3 = new Node(1);
        Node connectedRoot3 = solution.connect(root3);
        List<List<Integer>> expected3 = Arrays.asList(
            Arrays.asList(1)
        );
        Assertions.assertEquals(expected3, connectedRoot3.toLevelOrderList());
        Assertions.assertNull(connectedRoot3.next);

        // Test case 4: Complete binary tree
        Node root4 = new Node(1);
        root4.left = new Node(2);
        root4.right = new Node(3);
        root4.left.left = new Node(4);
        root4.left.right = new Node(5);
        root4.right.left = new Node(6);
        root4.right.right = new Node(7);

        Node connectedRoot4 = solution.connect(root4);
        List<List<Integer>> expected4 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6, 7)
        );
        Assertions.assertEquals(expected4, connectedRoot4.toLevelOrderList());
        Assertions.assertNull(connectedRoot4.next);
        Assertions.assertEquals(root4.left.next, root4.right);
        Assertions.assertNull(root4.right.next);
        Assertions.assertEquals(root4.left.left.next, root4.left.right);
        Assertions.assertEquals(root4.left.right.next, root4.right.left);
        Assertions.assertEquals(root4.right.left.next, root4.right.right);
        Assertions.assertNull(root4.right.right.next);

        // Test case 5: Skewed tree (right)
        Node root5 = new Node(1);
        root5.right = new Node(2);
        root5.right.right = new Node(3);
        root5.right.right.right = new Node(4);

        Node connectedRoot5 = solution.connect(root5);
        List<List<Integer>> expected5 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList(4)
        );
        Assertions.assertEquals(expected5, connectedRoot5.toLevelOrderList());
        Assertions.assertNull(connectedRoot5.next);
        Assertions.assertNull(connectedRoot5.right.next);
        Assertions.assertNull(connectedRoot5.right.right.next);
        Assertions.assertNull(connectedRoot5.right.right.right.next);

        // Test case 6: Skewed tree (left)
        Node root6 = new Node(1);
        root6.left = new Node(2);
        root6.left.left = new Node(3);
        root6.left.left.left = new Node(4);

        Node connectedRoot6 = solution.connect(root6);
        List<List<Integer>> expected6 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList(4)
        );
        Assertions.assertEquals(expected6, connectedRoot6.toLevelOrderList());
        Assertions.assertNull(connectedRoot6.next);
        Assertions.assertNull(connectedRoot6.left.next);
        Assertions.assertNull(connectedRoot6.left.left.next);
        Assertions.assertNull(connectedRoot6.left.left.left.next);
    }

    public Node connect(Node root) {
        if(root == null) return root;
        // 각 층별로 처리?
        List<Node> list = new ArrayList<>();
        list.add(root);

        while(!list.isEmpty()){
            List<Node> next = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                Node cur = list.get(i);
                if(i != list.size()-1){
                    cur.next = list.get(i+1);
                }
                if(cur.left != null) {
                    next.add(cur.left);
                }
                if(cur.right != null) {
                    next.add(cur.right);
                }
            }
            list = next;
        }

        return root;
    }
}
