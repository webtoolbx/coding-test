package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1513_NumberofSubstringsWithOnly1s {

    @Test
    void test() {
        System.out.println("result : " + numSub("0110111"));
    }

    public int numSub(String s) {
        // 1의 개수를 계산해서 1이 1개일때, 1이 2개일때 이런식으로 처리하는게 유리
        int answer = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                count++;
                answer+= count;
                answer = answer % (1000000007);
            } else {
                count = 0;
            }
        }

        return answer;
    }
}
