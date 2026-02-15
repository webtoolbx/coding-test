package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q67_AddBinary {

    @Test
    void test() {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        // 끝자리부터 더하기
        int idx1 = a.length() - 1;
        int idx2 = b.length() - 1;
        int pad = 0;
        StringBuilder sb = new StringBuilder();
        while(idx1 >= 0 || idx2 >= 0){
            int o1 = 0;
            int o2 = 0;
            if(idx1 >= 0){
                o1 = a.charAt(idx1) - 48;
                idx1--;
            }
            if(idx2 >= 0){
                o2 = b.charAt(idx2) - 48;
                idx2--;
            }
            sb.append((o1+o2+pad) % 2);
            if(o1 + o2 + pad >= 2){
                pad = 1;
            } else {
                pad = 0;
            }

        }
        if(pad == 1) sb.append('1');
        return sb.reverse().toString();
    }

    // prev code
    public String addBinary2(String a, String b) {
        int max = Math.max(a.length(), b.length());
        int al = a.length()-1;
        int bl = b.length()-1;
        StringBuilder sb = new StringBuilder();
        boolean over = false;
        for(int i = 0; i < max; i++){
            Character ac = null;
            if(al - i >= 0){
                ac = a.charAt(al-i);
            }
            Character bc = null;
            if(bl - i >= 0){
                bc = b.charAt(bl-i);
            }
            int count = 0;
            if(over){
                count++;
            }
            if(ac != null && ac == '1'){
                count++;
            }
            if(bc != null && bc == '1'){
                count++;
            }
            if(count >= 2){
                over = true;
            } else {
                over = false;
            }
            if(count % 2 ==0){
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        if(over) sb.append("1");
        sb = sb.reverse();
        return sb.toString();
    }
}
