package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Quest2_LicenseKeyFormatting {

    @Test
    void test() {
        Assertions.assertEquals("5F3Z-2E9W", licenseKeyFormatting("5F3Z-2e-9-w", 4));
        Assertions.assertEquals("2-5G-3J", licenseKeyFormatting("2-5g-3-J", 2));
        Assertions.assertEquals("AA-AA", licenseKeyFormatting("--a-a-a-a--", 2));
        Assertions.assertEquals("", licenseKeyFormatting("---", 3));
    }

    public String licenseKeyFormatting(String s, int k) {
        // 첫번째 구성을 먼저 찾기
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        int counter = 0;
        for(int i = size -1; i >= 0; i--){
            char c = s.charAt(i);
            if(c != '-'){
                sb.append(c);
                counter++;
                if(k == counter){
                    sb.append('-');
                    counter = 0;
                }
            }
        }
        sb = sb.reverse();
        if(sb.isEmpty()){
            return "";
        }
        if(sb.charAt(0) == '-'){
            sb = sb.delete(0,1);
        }
        return sb.toString().toUpperCase();
    }
}
