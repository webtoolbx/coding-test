package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3355_ZeroArrayTransFormation1 {

    @Test
    void test() {
        boolean result = isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}});
        System.out.println("Result : " + result);
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 전체 계산이 아닌 동적 프로그래밍 처리
        int[] diffArray = new int[nums.length + 1];
        for(int[] query : queries){
            diffArray[query[0]] += 1;
            diffArray[query[1] + 1] -= 1;
        }
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += diffArray[i];
            if(nums[i] - total > 0){
                return false;
            }
        }

        return true;
    }
}
