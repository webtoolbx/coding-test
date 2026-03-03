package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q92_ReverseLinkedListII {

    @Test
    void test() {
        Q92_ReverseLinkedListII solution = new Q92_ReverseLinkedListII();

        // Case 1: head = [1,2,3,4,5], left = 2, right = 4 -> [1,4,3,2,5]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = solution.reverseBetween(head1, 2, 4);
        Assertions.assertEquals(1, result1.val);
        Assertions.assertEquals(4, result1.next.val);
        Assertions.assertEquals(3, result1.next.next.val);
        Assertions.assertEquals(2, result1.next.next.next.val);
        Assertions.assertEquals(5, result1.next.next.next.next.val);
        Assertions.assertNull(result1.next.next.next.next.next);

        // Case 2: head = [5], left = 1, right = 1 -> [5]
        ListNode head2 = new ListNode(5);
        ListNode result2 = solution.reverseBetween(head2, 1, 1);
        Assertions.assertEquals(5, result2.val);
        Assertions.assertNull(result2.next);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
