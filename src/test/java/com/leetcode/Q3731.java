package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Q3731 {

    @Test
    void test() {
        assertThat(findMissingElements(new int[]{1,4,2,5})).isEqualTo(List.of(3));
        assertThat(findMissingElements(new int[]{7,8,6,9})).isEqualTo(List.of());
        assertThat(findMissingElements(new int[]{5,1})).isEqualTo(List.of(2,3,4));
    }

    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(min > n) min = n;
            if(n > max) max = n;
            set.add(n);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = min+1; i < max; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
