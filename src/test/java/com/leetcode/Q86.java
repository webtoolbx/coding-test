package com.leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Q86 {

    @Test
    void test() {
        // 1 -> 4 -> 3 -> 2 -> 5 -> 2 리스트 만들기
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode result = new ListNode(1);
        result.next = new ListNode(2);
        result.next.next = new ListNode(2);
        result.next.next.next = new ListNode(4);
        result.next.next.next.next = new ListNode(3);
        result.next.next.next.next.next = new ListNode(5);

        // 테스트 실행
        assertThat(partition(head, 3)).isEqualTo(result);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode bigEqual = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode bigStart = bigEqual;
        ListNode result = small;

        while(head != null){
            if(head.val >= x){
                bigEqual.next = head;
                bigEqual = bigEqual.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        bigEqual.next = null;
        small.next = bigStart.next;
        return result.next;
    }
}
