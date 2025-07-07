package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q1556_ThousandSeparator {

    @Test
    void test() {
        String result = thousandSeparator(123456789);
        System.out.println("result : " + result);
    }

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        if(n == 0) return "0";
        while(n > 0){
            sb.append(n % 10);
            n /= 10;
            cnt++;
            if(cnt == 3 && n != 0){
                cnt = 0;
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}
