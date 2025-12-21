package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2110_NumberofSmoothDescentPeriodsofaStock {

    @Test
    void test() {
        System.out.println("result : " + getDescentPeriods(new int[]{3,2,1,4}));
    }

    public long getDescentPeriods(int[] prices) {
        // 4, 3, 2, 1
        // 4 + 3 + 2 + 1
        int prev = prices[0];
        int save = 1;
        long total = 1;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] + 1 == prev){
                save++;
                total += save;
            } else {
                save = 1;
                total++;
            }
            prev = prices[i];
        }

        return total;
    }
}
