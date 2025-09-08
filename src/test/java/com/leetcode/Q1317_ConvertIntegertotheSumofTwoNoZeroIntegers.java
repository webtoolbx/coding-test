package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1317_ConvertIntegertotheSumofTwoNoZeroIntegers {

    @Test
    void test() {
        System.out.println("result : " + getNoZeroIntegers(1));
    }

    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n / 2; i++){
            if(String.valueOf(i).indexOf("0") > -1){
                continue;
            }
            if(String.valueOf(n-i).indexOf("0") > -1){
                continue;
            }
            return new int[]{i, n-i};
        }
        return new int[]{1,1};
    }
}
