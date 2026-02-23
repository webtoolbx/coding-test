package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q21_MergeTwoSortedLists {

    @Test
    void test() {
        Q21_MergeTwoSortedLists solution = new Q21_MergeTwoSortedLists();

        // Case 1: list1 = [1,2,4], list2 = [1,3,4] -> [1,1,2,3,4,4]
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result1 = solution.mergeTwoLists(l1, l2);
        Assertions.assertEquals(1, result1.val);
        Assertions.assertEquals(1, result1.next.val);
        Assertions.assertEquals(2, result1.next.next.val);
        Assertions.assertEquals(3, result1.next.next.next.val);
        Assertions.assertEquals(4, result1.next.next.next.next.val);
        Assertions.assertEquals(4, result1.next.next.next.next.next.val);
        Assertions.assertNull(result1.next.next.next.next.next.next);

        // Case 2: list1 = [], list2 = [] -> []
        ListNode result2 = solution.mergeTwoLists(null, null);
        Assertions.assertNull(result2);

        // Case 3: list1 = [], list2 = [0] -> [0]
        ListNode result3 = solution.mergeTwoLists(null, new ListNode(0));
        Assertions.assertEquals(0, result3.val);
        Assertions.assertNull(result3.next);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null){
            current.next = list1;
        } else if(list2 != null){
            current.next = list2;
        }

        return dummy.next;
    }
}
