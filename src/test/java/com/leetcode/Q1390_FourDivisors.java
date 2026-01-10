package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q1390_FourDivisors {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(32, sumFourDivisors(new int[]{21, 4, 7}));
        Assertions.assertEquals(64, sumFourDivisors(new int[]{21, 21}));
        Assertions.assertEquals(0, sumFourDivisors(new int[]{1, 2, 3, 4, 5}));
    }

    public int sumFourDivisors(int[] nums) {
        // 약수가 4개인 것을 빠르게 구별?
        // 4개인 애들과 아닌 애들을 판별했으면 저장을 해놔야겠네
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            if(map.containsKey(n)){
                ans += map.get(n);
                continue;
            }
            if(set.contains(n)){
                continue;
            }
            int num = isFour(n);
            if(num > 0){
                ans += num;
                map.put(n, num);
            } else {
                set.add(n);
            }
        }
        return ans;
    }

    private int isFour(int num){
        if(num > 2){
            double sqrt = Math.sqrt(num);
            int max = (int) Math.ceil(sqrt);
            if(max * max == num) return 0;
            int save = -1;
            for(int i = 2; i < max; i++){
                if(num % i == 0){
                    if(save == -1){
                        save = i;
                    } else {
                        return 0;
                    }
                }
            }
            if(save > 0){
                return 1 + num + save + (num / save);
            }
        }
        return 0;
    }
}
