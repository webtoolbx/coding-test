package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q3074_AppleRedistributionintoBoxes {

    @Test
    void test() {
        Assertions.assertEquals(2, minimumBoxes(new int[]{1,3,2}, new int[]{4,3,1,5,2}));
        Assertions.assertEquals(4, minimumBoxes(new int[]{5,5,5}, new int[]{2,4,2,7}));
    }

    // #Array
    public int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;
        for(int a : apple){
            count += a;
        }

        int ans = 0;
        Arrays.sort(capacity);
        for(int i = capacity.length - 1; i >= 0; i--){
            if(count <= 0){
                break;
            }
            ans++;
            count -= capacity[i];
        }

        return ans;
    }
}
