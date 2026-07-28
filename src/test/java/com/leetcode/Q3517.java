package com.leetcode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Q3517 {

    @Test
    void test() {
        assertThat(smallestPalindrome("z")).isEqualTo("z");
        assertThat(smallestPalindrome("babab")).isEqualTo("abbba");
        assertThat(smallestPalindrome("daccad")).isEqualTo("acddca");
    }

    public String smallestPalindrome(String s) {
        // 답이 있는건 보장
        // 사전순
        // 홀수인 친구는 가운데에 하나 놔줘야함
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        Character middle = null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(arr[i] % 2 == 1){
                arr[i]--;
                middle = (char) ('a' + i);
            }
            for(int j = 0; j < arr[i] / 2; j++){
                sb.append((char) ('a' + i));
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();

        if(middle == null){
            return sb.toString() + reverse.toString();
        }
        return sb.toString() + middle + reverse.toString();
    }
}
