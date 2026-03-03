package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1545_FindKthBitinNthBinaryString {

    @Test
    void test() {
        Q1545_FindKthBitinNthBinaryString solution = new Q1545_FindKthBitinNthBinaryString();
        Assertions.assertEquals('0', solution.findKthBit(3, 1));
        Assertions.assertEquals('1', solution.findKthBit(4, 11));
        Assertions.assertEquals('0', solution.findKthBit(1, 1));
        Assertions.assertEquals('1', solution.findKthBit(2, 3));
    }

    public char findKthBit(int n, int k) {
        String cur = "0";
        while(n != 1){
            StringBuilder sb = new StringBuilder(cur);
            sb.append("1");
            for(int i = cur.length()-1; i >= 0; i--){
                if(cur.charAt(i) == '0'){
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            cur = sb.toString();
            n--;
        }
        return cur.charAt(k-1);
    }

    public char findKthBit2(int n, int k) {
        // 비트 연산으로 풀 수 있지 않을까?
        // int cnt = 1;
        // for(int i = 2; i <= 20; i++){
        //     cnt = cnt * 2 + 1;
        // }
        // System.out.println(cnt);
        boolean[] bit = new boolean[1048575];
        int size = 1;
        while(n != 1){
            bit[size] = true;
            for(int i = 1; i <= size; i++){
                bit[size + i] = bit[size-i] ? false : true;
            }
            size = size * 2 + 1;
            n--;
        }
        return bit[k-1] ? '1' : '0';
    }
}
