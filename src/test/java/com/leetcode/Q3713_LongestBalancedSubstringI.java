package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q3713_LongestBalancedSubstringI {

    @Test
    void test() {
        Assertions.assertEquals(4, longestBalanced("aabb"));
        Assertions.assertEquals(2, longestBalanced("ab"));
        Assertions.assertEquals(0, longestBalanced("a"));
        Assertions.assertEquals(6, longestBalanced("aabbcc"));
    }

    public int longestBalanced(String s) {
        // 길이가 얼마 안되서 0부터 시작하는 것부터 차례대로 가도 되긴 함
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                int cur = s.charAt(j);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                Integer prev = null;
                boolean isSame = true;
                for(int v : map.values()){
                    if(prev != null && prev != v){
                        isSame = false;
                        break;
                    }
                    prev = v;
                }
                if(isSame){
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        return answer;
    }
}
