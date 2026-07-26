package com.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1464 {

    @Test
    void test() {
        assertThat(maxProduct(new int[]{3,4,5,2})).isEqualTo(12);
        assertThat(maxProduct(new int[]{1,5,4,5})).isEqualTo(16);
    }

    public int maxProduct(int[] nums) {
        // 그냥 가장 큰 수 2개
        int max1 = 0;
        int max2 = 0;
        for(int n : nums){
            if(n > max1){
                max2 = max1;
                max1 = n;
            } else if(n > max2){
                max2 = n;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

}
