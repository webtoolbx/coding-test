package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q1071_GreatCommonDivisorOfStrings {

    @Test
    void test() {
        System.out.println("result : " + gcdOfStrings("ABCABC", "ABC"));
        System.out.println("result : " + gcdOfStrings("ABABAB", "ABAB"));
        System.out.println("result : " + gcdOfStrings("LEET", "CDOE"));
    }

    // 최소 공배수를 구하는 문제였어
    public String gcdOfStrings(String str1, String str2){
        if(!(str1 + str2).equals(str2 + str1)) return "";

        return str2.substring(0, getGcd(str1.length(), str2.length()));
    }

    private int getGcd(int i, int j){
        return j == 0 ? i : getGcd(j, i % j);
    }




    /*public String gcdOfStrings(String str1, String str2) {
        // 반복인지 체크하는 방법
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 >= len2) return check(str1, str2);

        return check(str2, str1);
    }

    // str1 > str2
    public String check(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        for(int i = 1; i <= len2; i++){
            if(len2 % i == 0){
                int tempLen = len2 / i;
                String temp = str2.substring(0, tempLen);
                if(!str2.equals(add(temp, i))){
                    continue;
                }
                if(len1 % (tempLen) != 0){
                    continue;
                }
                if(str1.equals(add(temp, len1 / tempLen))){
                    return temp;
                }
            }
        }
        return "";
    }

    private String add(String str, int cnt){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++){
            sb.append(str);
        }
        return sb.toString();
    }*/
}
