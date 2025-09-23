package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q165_CompareVersionNumbers {

    @Test
    void test() {
        System.out.println("result : " + compareVersion("1.01", "1.001"));
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int idx = 0;
        while(idx < len1 && idx < len2){
            int num1 = Integer.parseInt(arr1[idx]);
            int num2 = Integer.parseInt(arr2[idx]);
            if(num1 > num2){
                return 1;
            } else if(num1 < num2){
                return -1;
            }
            idx++;
        }
        if(len1 > len2){
            for(int i = idx; i < len1; i++){
                int num1 = Integer.parseInt(arr1[i]);
                // System.out.println(num1);
                if(num1 > 0){
                    return 1;
                }
            }
        } else if(len1 < len2){
            for(int i = idx; i < len2; i++){
                int num2 = Integer.parseInt(arr2[i]);
                if(num2 > 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
