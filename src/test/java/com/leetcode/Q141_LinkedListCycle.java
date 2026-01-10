package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q141_LinkedListCycle {

    @Test
    void test() {
        // Case 1: Cycle exists (3 -> 2 -> 0 -> -4 -> 2)
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Cycle

        Assertions.assertTrue(hasCycle1(head1));
        Assertions.assertTrue(hasCycle2(head1));

        // Case 2: Cycle exists (1 -> 2 -> 1)
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);
        head2.next = node2_2;
        node2_2.next = head2; // Cycle

        Assertions.assertTrue(hasCycle1(head2));
        Assertions.assertTrue(hasCycle2(head2));

        // Case 3: No cycle (1)
        ListNode head3 = new ListNode(1);
        Assertions.assertFalse(hasCycle1(head3));
        Assertions.assertFalse(hasCycle2(head3));
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
