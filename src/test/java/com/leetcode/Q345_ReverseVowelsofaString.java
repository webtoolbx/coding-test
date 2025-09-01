package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Set;

public class Q345_ReverseVowelsofaString {

    @Test
    void test() {
        System.out.println("result : " + reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        while(left < right){
            if(!vowels.contains(sb.charAt(left))){
                left++;
                continue;
            }
            if(!vowels.contains(sb.charAt(right))){
                right--;
                continue;
            }
            char temp = sb.charAt(left);
            sb.replace(left, left+1, String.valueOf(sb.charAt(right)));
            sb.replace(right, right+1, String.valueOf(temp));
            left++;
            right--;
        }
        return sb.toString();
    }
}
