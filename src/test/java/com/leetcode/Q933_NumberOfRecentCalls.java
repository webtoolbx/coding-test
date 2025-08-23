package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q933_NumberOfRecentCalls {

    @Test
    void test() {
    }

    int[] pings = new int[10000];
    int idx = 0;
    int ping = 0;
    public RecentCounter() {

    }

    public int ping(int t) {
        pings[idx] = t;
        while(ping < idx){
            if(pings[ping] + 3000 >= t){
                break;
            }
            ping++;
        }
        idx++;

        return idx - ping;
    }

    // Queue<Integer> queue = null;
    // public void RecentCounter() {
    //     queue = new LinkedList<>();
    // }
    //
    // public int ping(int t) {
    //     queue.add(t);
    //     while(t > queue.peek() + 3000){
    //         queue.poll();
    //     }
    //     return queue.size();
    // }
}
