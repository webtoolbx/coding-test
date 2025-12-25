package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q3075_MaximizeHappinessofSelectedChildren {

    @Test
    void test() {
        Assertions.assertEquals(4, maximumHappinessSum(new int[]{1, 2, 3}, 2));
        Assertions.assertEquals(1, maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
        Assertions.assertEquals(5, maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;

        Arrays.sort(happiness);
        int add = 0;
        for(int i = happiness.length - 1; i >= 0; i--){
            if(happiness[i] - add <= 0) break;
            if(k == 0) break;
            ans += (happiness[i] - add);
            add++;
            k--;
        }

        return ans;
    }
}
