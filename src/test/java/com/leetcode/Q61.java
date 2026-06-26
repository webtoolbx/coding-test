package com.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Q61 {

    @Test
    void test() {
        assertThat(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2))
            .isEqualTo(new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(2, new ListNode(3))))));
    }

    public ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        ListNode node = head;
        ListNode tail = null;
        while(node != null){
            cnt++;
            if(node.next == null){
                tail = node;
            }
            node = node.next;
        }
        if(cnt == 0) return head;

        k = k % cnt;
        if(k == 0) return head;

        tail.next = head;
        for(int i = 0; i < cnt - k - 1; i++){
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;

        return result;
    }

}
