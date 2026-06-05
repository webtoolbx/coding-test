package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q15 {

    @Test
    void testThreeSum() {
        Q15 solution = new Q15();

        // Test case 1: Basic example
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(-1, -1, 2),
            Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result1 = solution.threeSum(nums1);
        // Sort both the result and expected lists for consistent comparison
        result1.forEach(list -> list.sort(Integer::compareTo));
        expected1.forEach(list -> list.sort(Integer::compareTo));
        Assertions.assertTrue(result1.size() == expected1.size() && result1.containsAll(expected1) && expected1.containsAll(result1));


        // Test case 2: No solution
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> expected2 = Arrays.asList();
        List<List<Integer>> result2 = solution.threeSum(nums2);
        Assertions.assertEquals(expected2, result2);

        // Test case 3: Zeros
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> expected3 = Arrays.asList(Arrays.asList(0, 0, 0));
        List<List<Integer>> result3 = solution.threeSum(nums3);
        Assertions.assertEquals(expected3, result3);

        // Test case 4: Duplicates
        int[] nums4 = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected4 = Arrays.asList(Arrays.asList(-2, 0, 2));
        List<List<Integer>> result4 = solution.threeSum(nums4);
        result4.forEach(list -> list.sort(Integer::compareTo));
        expected4.forEach(list -> list.sort(Integer::compareTo));
        Assertions.assertTrue(result4.size() == expected4.size() && result4.containsAll(expected4) && expected4.containsAll(result4));

        // Test case 5: Larger numbers
        int[] nums5 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        List<List<Integer>> expected5 = Arrays.asList(
            Arrays.asList(-5, 0, 5),
            Arrays.asList(-5, 1, 4),
            Arrays.asList(-5, 2, 3),
            Arrays.asList(-4, -1, 5),
            Arrays.asList(-4, 0, 4),
            Arrays.asList(-4, 1, 3),
            Arrays.asList(-3, -2, 5),
            Arrays.asList(-3, -1, 4),
            Arrays.asList(-3, 0, 3),
            Arrays.asList(-3, 1, 2),
            Arrays.asList(-2, -1, 3),
            Arrays.asList(-2, 0, 2),
            Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result5 = solution.threeSum(nums5);
        result5.forEach(list -> list.sort(Integer::compareTo));
        expected5.forEach(list -> list.sort(Integer::compareTo));
        Assertions.assertTrue(result5.size() == expected5.size() && result5.containsAll(expected5) && expected5.containsAll(result5));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // 기준점 + 2개의 수 격차 = 0
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if (sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }


        return result;
    }

    // time limit O(N^3)
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i+1; j < nums.length - 1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        int[] arr = new int[3];
                        arr[0] = nums[i];
                        arr[1] = nums[j];
                        arr[2] = nums[k];
                        Arrays.sort(arr);

                        String val = Arrays.toString(arr);
                        if(!set.contains(val)){
                            set.add(val);
                            result.add(Arrays.stream(arr).boxed().toList());
                        }
                    }
                }
            }
        }

        return result;
    }
}
