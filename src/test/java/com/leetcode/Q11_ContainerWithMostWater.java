package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q11_ContainerWithMostWater {

    @Test
    void test() {
        System.out.println("result : " + maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int idx1 = 0;
        int idx2 = height.length - 1;
        int answer = 0;
        // 둘 중에 높은 것을 유지
        while (idx1 < idx2) {
            int min = Math.min(height[idx1], height[idx2]);
            answer = Math.max(min * (idx2 - idx1), answer);
            if (height[idx1] > height[idx2]) {
                idx2--;
            } else {
                idx1++;
            }
        }

        return answer;
    }
}
