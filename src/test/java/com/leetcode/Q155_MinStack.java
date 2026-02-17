package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class Q155_MinStack {

    @Test
    void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());    // return 0
        Assertions.assertEquals(-2, minStack.getMin()); // return -2
    }

    class MinStack {

        // 배열에 저장해두고 위치 기록
        int[] arr;
        int idx = -1;
        SortedMap<Integer, Integer> map = new TreeMap<>();

        public MinStack() {
            arr = new int[3 * 10000];
        }

        public void push(int val) {
            idx++;
            arr[idx] = val;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        public void pop() {
            int cnt = map.get(arr[idx]);
            if(cnt == 1){
                map.remove(arr[idx]);
            } else {
                map.put(arr[idx], cnt-1);
            }
            idx--;
        }

        public int top() {
            return arr[idx];
        }

        public int getMin() {
            return map.firstKey();
        }
    }
}
