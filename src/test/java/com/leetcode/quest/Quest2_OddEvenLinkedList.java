package com.leetcode.quest;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest2_OddEvenLinkedList {

    @Test
    void test() {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result1 = oddEvenList(head1);
        Assertions.assertEquals(1, result1.val);
        Assertions.assertEquals(3, result1.next.val);
        Assertions.assertEquals(5, result1.next.next.val);
        Assertions.assertEquals(2, result1.next.next.next.val);
        Assertions.assertEquals(4, result1.next.next.next.next.val);
        Assertions.assertNull(result1.next.next.next.next.next);

        ListNode head2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode result2 = oddEvenList(head2);
        int[] expected = {2, 3, 6, 7, 1, 5, 4};
        ListNode curr = result2;
        for(int val : expected) {
            Assertions.assertEquals(val, curr.val);
            curr = curr.next;
        }
        Assertions.assertNull(curr);
    }

    // #LinkedList
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        // 연결을 두개로 구분하고 구분된 값을 마지막에 이어주면 될거 같은데?
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
