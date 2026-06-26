package com.leetcode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.leetcode.ListNode listNode = (com.leetcode.ListNode) o;

        // 현재 노드의 값 비교 && 다음 노드들의 연결 구조 비교
        return val == listNode.val && java.util.Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(val, next);
    }
}