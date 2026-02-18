package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q138_CopyListwithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    @Test
    void test() {
        Q138_CopyListwithRandomPointer solution = new Q138_CopyListwithRandomPointer();

        // Case 1: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copied = solution.copyRandomList(n1);

        Assertions.assertNotSame(n1, copied);
        Assertions.assertEquals(7, copied.val);
        Assertions.assertNull(copied.random);

        Assertions.assertEquals(13, copied.next.val);
        Assertions.assertEquals(7, copied.next.random.val);

        Assertions.assertEquals(11, copied.next.next.val);
        Assertions.assertEquals(1, copied.next.next.random.val);
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // 1. Copy all nodes and store mapping
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2. Assign next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
