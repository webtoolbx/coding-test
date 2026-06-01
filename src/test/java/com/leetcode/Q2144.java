package com.leetcode;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2144 {

    @Test
    void test() {
        Assertions.assertEquals(5, minimumCost(new int[]{1,2,3}));
        Assertions.assertEquals(23, minimumCost(new int[]{6,5,7,9,2,2}));
        Assertions.assertEquals(10, minimumCost(new int[]{5,5}));
    }

    public int minimumCost(int[] cost) {
        // 내림차순으로 정렬해서 순차적으로 가져가면
        Arrays.sort(cost);
        int result = 0;
        for(int i = cost.length - 1; i >= 0; i -= 3){
            result += cost[i];
            if(i > 0){
                result += cost[i-1];
            }
        }

        return result;
    }
}
