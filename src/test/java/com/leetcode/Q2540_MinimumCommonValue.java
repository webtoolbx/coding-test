package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q2540_MinimumCommonValue {

    @Test
    void test() {
        System.out.println("result : " + getCommon(new int[]{1,2,3}, new int[]{2,4}));
        System.out.println("result : " + getCommon(new int[]{1,2,3,6}, new int[]{2,3,4,5}));
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < size1 && idx2 < size2){
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            if(num1 == num2) {
                return num1;
            } else if(num1 > num2){
                idx2++;
            } else {
                idx1++;
            }
        }

        return -1;
    }
}
