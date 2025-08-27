package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q605_CanPlaceFlowers {

    @Test
    void test() {
        System.out.println("result : " + canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int answer = 0;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0){
                answer++;
            }
            return n <= answer;
        }
        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            flowerbed[0] = 1;
            answer++;
        }
        if(flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0){
            flowerbed[flowerbed.length-1] = 1;
            answer++;
        }
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if(count == 0 || count == 1){
                    count++;
                } else {
                    count = 1;
                    answer++;
                }
            } else {
                count = 0;
            }
        }
        return n <= answer;
    }
}
