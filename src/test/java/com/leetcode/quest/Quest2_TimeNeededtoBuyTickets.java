package com.leetcode.quest;

import org.junit.jupiter.api.Test;

public class Quest2_TimeNeededtoBuyTickets {

    @Test
    void test() {
    }

    // #queue
    public int timeRequiredToBuy(int[] tickets, int k) {
        // 굳이 큐로 다 돌지 않아도 되는거고
        int max = tickets[k];
        // 전과 본인은 같은 횟수
        // 이후의 친구들은 -1 까지만 덧셈
        int ans = 0;
        for(int i = 0; i < tickets.length; i ++){
            if(i <= k){
                ans += Math.min(tickets[i], max);
            } else {
                ans += Math.min(tickets[i], max-1);
            }
        }
        return ans;
    }

    // #queue
    public int timeRequiredToBuy2(int[] tickets, int k) {
        // 굳이 큐로 한번 풀어보기?

        int max = tickets[k];
        // 전과 본인은 같은 횟수
        // 이후의 친구들은 -1 까지만 덧셈
        int ans = 0;
        for(int i = 0; i < tickets.length; i ++){
            if(i <= k){
                ans += Math.min(tickets[i], max);
            } else {
                ans += Math.min(tickets[i], max-1);
            }
        }
        return ans;
    }
}
