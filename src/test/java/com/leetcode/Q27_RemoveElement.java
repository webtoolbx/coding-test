package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q27_RemoveElement {

    @Test
    void test() {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = removeElement(nums1, val1);
        Assertions.assertEquals(2, k1);
        Arrays.sort(nums1, 0, k1);
        for (int i = 0; i < k1; i++) {
            Assertions.assertNotEquals(val1, nums1[i]);
        }

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = removeElement(nums2, val2);
        Assertions.assertEquals(5, k2);
        Arrays.sort(nums2, 0, k2);
        for (int i = 0; i < k2; i++) {
            Assertions.assertNotEquals(val2, nums2[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 0) return 0;
        // 진짜 idx
        // 찾는 idx
        // 현재 값이 틀린 경우 그 idx 부터 증가하면서 가져오기
        // 찾다가 아니면 삭제하고 그 다음부터 검색할 수 있도록 기록해두기?

        int i = 0;
        int last = n-1;
        while(i < last){
            if(nums[i] == val){
                if(nums[last] == val){
                    last--;
                } else {
                    nums[i] = nums[last];
                    i++;
                    last--;
                }
            } else {
                i++;
            }
        }
        if(i == last){
            if(nums[i] == val){
                last--;
            }
        }

        return last+1;
    }
}
