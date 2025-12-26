package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Quest3_ImplementQueueusingStacks {

    @Test
    void test() {
        // 초기화
        MyQueue();

        push(1);
        push(2);

        Assertions.assertEquals(1, peek());
        Assertions.assertEquals(1, pop());
        Assertions.assertFalse(empty());
        
        Assertions.assertEquals(2, pop());
        Assertions.assertTrue(empty());
    }

    // #queue
    Stack<Integer> s1;
    Stack<Integer> s2;

    public void MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // 한쪽은 비어 있어야하고 s1 -> s2 로 옮기고 s1에 넣을 값을 넣고 s2의 값을 순차적으로 넣는다.
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
