package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class Q1493_LongestSubarrayof1sAfterDeletingOneElement {

    @Test
    void test() {
        System.out.println("result : " + longestSubarray(new int[]{1,1,0,1}));
        System.out.println("result : " + longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println("result : " + longestSubarray(new int[]{1,1,1}));

        System.out.println("result : " + longestSubarray2(new int[]{1,1,0,1}));
        System.out.println("result : " + longestSubarray2(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println("result : " + longestSubarray2(new int[]{1,1,1}));
    }

    public int longestSubarray(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        boolean containZero = false;
        int result = 0;
        for(int num : nums){
            if(num == 0){
                result = Math.max(result, queue.size()-1);
                if(containZero){
                    while(!queue.isEmpty()){
                        if(queue.poll() == 0){
                            break;
                        }
                    }
                }
                queue.add(num);
                containZero = true;
            } else {
                queue.add(num);
            }
        }
        return Math.max(result, queue.size()-1);
    }

    public int longestSubarray2(int[] nums) {
        int result = 0;
        int zeroCount = 0;
        int start = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }
            while(zeroCount > 1) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            result = Math.max(result, i - start);
        }
        return result;
    }
}
