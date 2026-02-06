package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q3634_MinimumRemovalstoBalanceArray {

    @Test
    void test() {
        Assertions.assertEquals(2, minRemoval(new int[]{4, 1, 2, 7}, 4));
        Assertions.assertEquals(0, minRemoval(new int[]{1, 5, 2}, 5));
        Assertions.assertEquals(4, minRemoval(new int[]{1, 10, 100, 1000, 10000}, 2));
    }

    public int minRemoval(int[] nums, int k) {
        // 정렬을 해서 왼쪽에서 빠를지, 오른쪽에서 빠를지 둘 중 하나겠지 뭐
        // 는 양쪽에서 줄이는게 더 빠를 수도 있네 ㅎㅎ
        int left = 0;
        int right = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        while(left < n){
            while(right < n && (long) nums[left] * k >= nums[right]){
                right++;
            }
            answer = Math.min(n - (right-left), answer);

            left++;
        }
        return answer;
    }
}
