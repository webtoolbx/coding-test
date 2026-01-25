package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q135_Candy {

    @Test
    void test() {
        Assertions.assertEquals(5, candy(new int[]{1,0,2}));
        Assertions.assertEquals(4, candy(new int[]{1,2,2}));

        Assertions.assertEquals(5, candy2(new int[]{1,0,2}));
        Assertions.assertEquals(4, candy2(new int[]{1,2,2}));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 0) return 0;

        int[] candy = new int[n];
        candy[0] = 1;
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            } else if(ratings[i] == ratings[i-1]){
                candy[i] = 1;
            } else {
                if(candy[i-1] > 1){
                    candy[i] = 1;
                } else {
                    // 이 때에 뒤로 돌아가기
                    candy[i] = 1;
                    for(int j = i-1; j >= 0; j--){
                        if(ratings[j] > ratings[j+1] && candy[j] == candy[j+1]){
                            candy[j] = candy[j] + 1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += candy[i];
        }

        return cnt;
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // 왼쪽에서 오른쪽으로
        for(int i = 1; i < n; i++){
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt += candies[i];
        }
        return cnt;
    }
}
