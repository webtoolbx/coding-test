package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {

    @Test
    void test() {
        Q78_Subsets solution = new Q78_Subsets();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        List<List<Integer>> expected1 = List.of(
            List.of(),
            List.of(1),
            List.of(2),
            List.of(1, 2),
            List.of(3),
            List.of(1, 3),
            List.of(2, 3),
            List.of(1, 2, 3)
        );
        Assertions.assertEquals(expected1.size(), result1.size());
        Assertions.assertTrue(result1.containsAll(expected1));
        Assertions.assertTrue(expected1.containsAll(result1));

        // Test case 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsets(nums2);
        List<List<Integer>> expected2 = List.of(
            List.of(),
            List.of(0)
        );
        Assertions.assertEquals(expected2.size(), result2.size());
        Assertions.assertTrue(result2.containsAll(expected2));
        Assertions.assertTrue(expected2.containsAll(result2));
    }

    public List<List<Integer>> subsets(int[] nums) {
        // 각 요소를 포함할지 안할지
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        // 각 요소마다 지금 값을 추가한 것을 삽입해주면
        // 각 요소가 들어간 요소와 안 들어간 요소가 존재할 것입니다.
        for(int n : nums){
            List<List<Integer>> newList = new ArrayList<>();
            for(List<Integer> list : answer){
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(n);
                newList.add(temp);
            }
            answer.addAll(newList);
        }

        return answer;
    }
}
