package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q2125_NumberofLaserBeamsinaBank {

    @Test
    void test() {
        System.out.println("result : " + numberOfBeams(new String[]{"011001","000000","010100","001000"}));
    }

    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int div = 0;
        for(String b : bank){
            int count = 0;
            for(char c : b.toCharArray()){
                if(c == '1'){
                    count++;
                }
            }
            ans += div * count;
            if(count > 0){
                div = count;
            }
        }
        return ans;
    }
}
