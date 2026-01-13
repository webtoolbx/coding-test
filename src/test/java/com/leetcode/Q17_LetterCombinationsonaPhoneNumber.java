package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17_LetterCombinationsonaPhoneNumber {

    @Test
    void test() {
        // Case 1: "23"
        List<String> result1 = letterCombinations("23");
        List<String> expected1 = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");
        Assertions.assertEquals(expected1.size(), result1.size());
        Assertions.assertTrue(result1.containsAll(expected1));

        // Case 2: ""
        Assertions.assertEquals(List.of(), letterCombinations(""));

        // Case 3: "2"
        Assertions.assertEquals(List.of("a", "b", "c"), letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', List.of("a","b","c"));
        map.put('3', List.of("d","e","f"));
        map.put('4', List.of("g","h","i"));
        map.put('5', List.of("j","k","l"));
        map.put('6', List.of("m","n","o"));
        map.put('7', List.of("p","q","r","s"));
        map.put('8', List.of("t","u","v"));
        map.put('9', List.of("w","x","y","z"));

        List<String> answer = new ArrayList<>();
        answer.add("");
        for(char digit : digits.toCharArray()){
            List<String> list = map.get(digit);
            List<String> newList = new ArrayList<>();
            for(String s : list){
                for(String a : answer){
                    newList.add(a + s);
                }
            }
            answer = newList;
        }
        return answer;
    }
}
