package com.leetcode.quest;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest1_RemoveDuplicatesfromSortedList {

    @Test
    void test() {
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result1 = deleteDuplicates(head1);
        Assertions.assertEquals(1, result1.val);
        Assertions.assertEquals(2, result1.next.val);
        Assertions.assertNull(result1.next.next);

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode result2 = deleteDuplicates(head2);
        Assertions.assertEquals(1, result2.val);
        Assertions.assertEquals(2, result2.next.val);
        Assertions.assertEquals(3, result2.next.next.val);
        Assertions.assertNull(result2.next.next.next);
    }

    // #LinkedList
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
