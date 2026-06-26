package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class Q19 {

    // 1. 테스트 대상 ListNode 정의
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // 3. 실행 가능한 테스트 메소드
    @Test
    void test() {
        // Given: [1 -> 2 -> 3 -> 4 -> 5] 리스트 생성
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // When: 뒤에서 2번째 노드(4) 삭제
        ListNode result = removeNthFromEnd(head, 2);

        // Then: 결과가 [1 -> 2 -> 3 -> 5]인지 검증
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
        assertNull(result.next.next.next.next); // 끝이 null인지 확인
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 전체 길이는 모르고
        // 배열에 저장해두고 index 로 돌아갈까?
        ListNode[] nodeArr = new ListNode[30];
        int idx = 0;
        ListNode node = head;
        while(node != null){
            nodeArr[idx++] = node;
            node = node.next;
        }

        // 삭제 대상이 첫번째면 그냥 2번 리턴
        if(idx - n == 0) return nodeArr[1];

        nodeArr[idx-n-1].next = nodeArr[idx-n].next;
        return head;
    }
}
