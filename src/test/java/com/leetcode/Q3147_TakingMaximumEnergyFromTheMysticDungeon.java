package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q3147_TakingMaximumEnergyFromTheMysticDungeon {

    @Test
    void test() {
        System.out.println(maximumEnergy(new int[]{5,2,-10,-5,1}, 3));
    }

    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        // 중간부터 시작할 수 있으니 도달할 수 있는 역순으로 찾기
        for(int i = energy.length - k; i < energy.length; i++){
            int sum = 0;
            for(int j = i; j >= 0; j -= k){
                sum += energy[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
