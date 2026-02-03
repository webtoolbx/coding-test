package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q202_HappyNumber {

    @Test
    void test() {
        Assertions.assertTrue(isHappy(19));
        Assertions.assertFalse(isHappy(2));
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1 ? true : false;
    }

    public int getNext(int n){
        int next = 0;
        while(n > 0){
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}
