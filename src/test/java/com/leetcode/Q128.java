package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q128 {

    @Test
    void testLongestConsecutive() {
        Q128 solution = new Q128();

        // Test case 1: Example from LeetCode
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        Assertions.assertEquals(4, solution.longestConsecutive(nums1)); // Expected: [1, 2, 3, 4]

        // Test case 2: Another example from LeetCode
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Assertions.assertEquals(9, solution.longestConsecutive(nums2)); // Expected: [0, 1, 2, 3, 4, 5, 6, 7, 8]

        // Test case 3: Empty array
        int[] nums3 = {};
        Assertions.assertEquals(0, solution.longestConsecutive(nums3));

        // Test case 4: Single element array
        int[] nums4 = {1};
        Assertions.assertEquals(1, solution.longestConsecutive(nums4));

        // Test case 5: No consecutive elements
        int[] nums5 = {1, 5, 9, 13};
        Assertions.assertEquals(1, solution.longestConsecutive(nums5));

        // Test case 6: Array with duplicates
        int[] nums6 = {1, 2, 0, 1};
        Assertions.assertEquals(3, solution.longestConsecutive(nums6)); // Expected: [0, 1, 2]

        // Test case 7: Negative numbers
        int[] nums7 = {-1, 0, 1, 2, 3};
        Assertions.assertEquals(5, solution.longestConsecutive(nums7));

        // Test case 8: Unsorted array with duplicates and gaps
        int[] nums8 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        Assertions.assertEquals(7, solution.longestConsecutive(nums8)); // Expected: [-1, 0, 1, 3, 4, 5, 6, 7, 8, 9] -> [-1,0,1] and [3,4,5,6,7,8,9] -> 7
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        // 연속하는거 연속이 끊어지는지 이어지는지
        // 버려서 연속이 이어질 수도 있고
        // 추가해서 연속이 이어질수도?
        Arrays.sort(nums);
        int max = 1;
        int con = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;

            if(nums[i] == nums[i-1] + 1){
                con++;
            } else { // if(nums[i] != nums[i-1]) is implicitly handled by the 'continue' above
                max = Math.max(max, con);
                con = 1;
            }
        }
        max = Math.max(max, con);
        return max;
    }
}
