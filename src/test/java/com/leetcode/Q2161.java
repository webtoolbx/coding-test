package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2161 {

    @Test
    void testPivotArray() {
        Q2161 solution = new Q2161();

        // Test case 1: Example from LeetCode
        int[] nums1 = {9, 12, 5, 10, 14, 3, 10};
        int pivot1 = 10;
        int[] expected1 = {9, 5, 3, 10, 10, 12, 14};
        Assertions.assertArrayEquals(expected1, solution.pivotArray(nums1, pivot1));

        // Test case 2: Another example from LeetCode
        int[] nums2 = {-3, 4, 3, 2};
        int pivot2 = 2;
        int[] expected2 = {-3, 2, 4, 3};
        Assertions.assertArrayEquals(expected2, solution.pivotArray(nums2, pivot2));

        // Test case 3: All elements are less than pivot
        int[] nums3 = {1, 2, 3};
        int pivot3 = 5;
        int[] expected3 = {1, 2, 3};
        Assertions.assertArrayEquals(expected3, solution.pivotArray(nums3, pivot3));

        // Test case 4: All elements are greater than pivot
        int[] nums4 = {5, 6, 7};
        int pivot4 = 3;
        int[] expected4 = {5, 6, 7};
        Assertions.assertArrayEquals(expected4, solution.pivotArray(nums4, pivot4));

        // Test case 5: All elements are equal to pivot
        int[] nums5 = {7, 7, 7};
        int pivot5 = 7;
        int[] expected5 = {7, 7, 7};
        Assertions.assertArrayEquals(expected5, solution.pivotArray(nums5, pivot5));

        // Test case 6: Empty array
        int[] nums6 = {};
        int pivot6 = 0;
        int[] expected6 = {};
        Assertions.assertArrayEquals(expected6, solution.pivotArray(nums6, pivot6));

        // Test case 7: Array with one element (less than pivot)
        int[] nums7 = {1};
        int pivot7 = 5;
        int[] expected7 = {1};
        Assertions.assertArrayEquals(expected7, solution.pivotArray(nums7, pivot7));

        // Test case 8: Array with one element (equal to pivot)
        int[] nums8 = {5};
        int pivot8 = 5;
        int[] expected8 = {5};
        Assertions.assertArrayEquals(expected8, solution.pivotArray(nums8, pivot8));

        // Test case 9: Array with one element (greater than pivot)
        int[] nums9 = {10};
        int pivot9 = 5;
        int[] expected9 = {10};
        Assertions.assertArrayEquals(expected9, solution.pivotArray(nums9, pivot9));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        // 0이상 정수 배열 nums, 정수 pivot
        // nums 를 재배열

        // 피벗보다 작으면 피벗보다 앞에, 피벗보다 크면 피벗보다 뒤에
        // 피벗과 동일, 피벗 위치에
        // Quick Sort?

        int[] result = new int[nums.length];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                result[idx++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == pivot){
                result[idx++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > pivot){
                result[idx++] = nums[i];
            }
        }

        return result;
    }
}
