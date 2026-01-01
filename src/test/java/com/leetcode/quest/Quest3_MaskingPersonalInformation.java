package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class Quest3_MaskingPersonalInformation {

    @Test
    void test() {
        Assertions.assertEquals("l*****e@leetcode.com", maskPII("LeetCode@LeetCode.com"));
        Assertions.assertEquals("a*****b@qq.com", maskPII("AB@qq.com"));
        Assertions.assertEquals("***-***-7890", maskPII("1(234)567-890"));
        Assertions.assertEquals("+*-***-***-5678", maskPII("86-(10)12345678"));
    }

    // #String
    public String maskPII(String s) {
        if(s.contains("@")){
            // 이메일
            String[] arr = s.split("@");
            return String.valueOf(arr[0].charAt(0)).toLowerCase() + "*****" + String.valueOf(arr[0].charAt(arr[0].length()-1)).toLowerCase() + "@" + arr[1].toLowerCase();
        } else {
            Set<String> set = Set.of("+", "-", "(", ")", " ");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                String cur = String.valueOf(s.charAt(i));
                if(!set.contains(cur)){
                    sb.append(cur);
                }
            }
            int size = sb.length();
            sb.delete(0, size-4);
            if(size == 10){
                return "***-***-" + sb.toString();
            } else {
                StringBuilder newsb = new StringBuilder("+");
                newsb.append("*".repeat(Math.max(0, size - 10)));
                newsb.append("-***-***-");
                newsb.append(sb);
                return newsb.toString();
            }
        }
    }
}
