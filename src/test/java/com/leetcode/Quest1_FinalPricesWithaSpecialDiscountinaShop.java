package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Quest1_FinalPricesWithaSpecialDiscountinaShop {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4,2,4,2,3}, finalPrices(new int[]{8,4,6,2,3}));
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, finalPrices(new int[]{1,2,3,4,5}));
        Assertions.assertArrayEquals(new int[]{9,0,1,6}, finalPrices(new int[]{10,1,1,6}));
    }

    public int[] finalPrices(int[] prices) {
        int[] ans = Arrays.copyOf(prices, prices.length);
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}
