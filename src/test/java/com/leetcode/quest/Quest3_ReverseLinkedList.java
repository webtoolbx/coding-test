package com.leetcode.quest;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest3_ReverseLinkedList {

    @Test
    void test() {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = reverseList(head1);
        int[] expected1 = {5, 4, 3, 2, 1};
        ListNode curr1 = result1;
        for(int val : expected1) {
            Assertions.assertEquals(val, curr1.val);
            curr1 = curr1.next;
        }
        Assertions.assertNull(curr1);

        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode result2 = reverseList(head2);
        Assertions.assertEquals(2, result2.val);
        Assertions.assertEquals(1, result2.next.val);
        Assertions.assertNull(result2.next.next);

        Assertions.assertNull(reverseList(null));
    }

    // #LinkedList
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;       // 다음 노드
            cur.next = prev;                // 현재 노드 방향 뒤집기
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
