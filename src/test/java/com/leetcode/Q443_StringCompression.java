package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q443_StringCompression {

    @Test
    void test() {
        System.out.println("result : " + compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    public int compress(char[] chars) {
        if(chars.length == 1) return 1;

        int idx = 1;
        char prev = chars[0];
        int count = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] != prev){
                if(count > 1){
                    char[] arr = String.valueOf(count).toCharArray();
                    for(int j = 0; j < arr.length; j++){
                        chars[idx++] = arr[j];
                    }
                }
                chars[idx] = chars[i];
                prev = chars[i];
                count = 1;
                idx++;
            } else {
                count++;
            }
        }
        if(count > 1){
            char[] arr = String.valueOf(count).toCharArray();
            for(int j = 0; j < arr.length; j++){
                chars[idx++] = arr[j];
            }
        }
        return idx;
    }
}
