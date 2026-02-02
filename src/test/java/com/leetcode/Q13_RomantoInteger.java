package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q13_RomantoInteger {

    @Test
    void test() {
        Assertions.assertEquals(3, romanToInt("III"));
        Assertions.assertEquals(58, romanToInt("LVIII"));
        Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < s.length() -1; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                answer -= map.get(s.charAt(i));
            } else {
                answer += map.get(s.charAt(i));
            }
        }

        return answer + map.get(s.charAt(s.length() - 1));
    }
}
