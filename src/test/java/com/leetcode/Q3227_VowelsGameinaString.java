package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

public class Q3227_VowelsGameinaString {

    @Test
    void test() {
        System.out.println("result : " + doesAliceWin("leetcoder"));
    }

    public boolean doesAliceWin(String s) {
        // 원래 짝수개고 한개만 남길 수 있다면? a 의 승리
        // 원래 홀수면 다 먹고 끝
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        for(char c : s.toCharArray()){
            if(vowelSet.contains(c)){
                return true;
            }
        }
        return false;
    }
}
