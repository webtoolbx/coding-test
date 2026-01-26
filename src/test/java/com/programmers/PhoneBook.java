package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PhoneBook {

    @Test
    void test() {
        Assertions.assertFalse(solution(new String[]{"119", "97674223", "1195524421"}));
        Assertions.assertTrue(solution(new String[]{"123", "456", "789"}));
        Assertions.assertFalse(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String s : phone_book){
            set.add(s);
        }
        for(String s : phone_book){
            for(int i = 1; i < s.length(); i++){
                if(set.contains(s.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}
