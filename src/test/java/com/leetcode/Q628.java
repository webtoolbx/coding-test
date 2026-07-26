package com.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Q628 {

    @Test
    void test() {
        assertThat(maximumProduct(new int[]{1,2,3})).isEqualTo(6);
        assertThat(maximumProduct(new int[]{1,2,3,4})).isEqualTo(24);
        assertThat(maximumProduct(new int[]{-1,-2,-3})).isEqualTo(-6);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int size = nums.length;

        // 1) 전부 양수, 3개만 있을 때
        max = Math.max(max, nums[size-1] * nums[size-2] * nums[size-3]);
        // 2) 양수1 + 음수2
        max = Math.max(max, nums[0] * nums[1] * nums[size-1]);
        // 음수가 만들어질 수 밖에 없는 케이스 -> 1번

        return max;
    }
}
