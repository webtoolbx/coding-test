package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120_Triangle {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        Assertions.assertEquals(11, minimumTotal(triangle1));

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        Assertions.assertEquals(-10, minimumTotal(triangle2));

        Assertions.assertEquals(11, minimumTotal2(triangle1));
        Assertions.assertEquals(-10, minimumTotal2(triangle2));
    }

    // #dp
    public int minimumTotal(List<List<Integer>> triangle) {
        // 각 합을 다 더해서 내려와서 가장 밑에서 젱리 적은 수 고르면 되겠네
        // 배열로 하고 밑변의 길이를 크기로 하면 되겠다.
        if(triangle.size() == 1) return triangle.getFirst().getFirst();
        int size = triangle.getLast().size();
        int[] dp = new int[size];
        for(List<Integer> list : triangle){
            int[] nextDp = new int[size];
            for(int i = 0; i < list.size(); i++){
                if(i == 0){
                    nextDp[0] = dp[0] + list.getFirst();
                } else if(i == list.size()-1){
                    nextDp[i] = dp[list.size()-2] + list.getLast();
                } else {
                    nextDp[i] = Math.min(dp[i-1], dp[i]) + list.get(i);
                }
            }
            dp = nextDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int j : dp) {
            ans = Math.min(ans, j);
        }

        return ans;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        // top down 방식을 사용했는데 bottom-up 이 좀더 효율적이네
        int size = triangle.getLast().size();
        int[] dp = new int[size+1];
        for(int i = triangle.size()-1; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            int[] newDp = new int[size+1];
            for(int j = 0; j < list.size(); j++){
                newDp[j] = Math.min(dp[j], dp[j+1]) + list.get(j);
            }
            dp = newDp;
        }
        return dp[0];
    }
}
