package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Quest1_LastStoneWeight {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(1, lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        Assertions.assertEquals(1, lastStoneWeight(new int[]{1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for(int s : stones){
            queue.add(s);
        }

        while(queue.size() > 1){
            int a1 = queue.poll();
            int a2 = queue.poll();
            if(a1 != a2){
                queue.add(a1 - a2);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
