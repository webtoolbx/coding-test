package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Q334_IncreasingTripletSubsequence {

    @Test
    void test() {
        System.out.println("result : " + increasingTriplet(new int[]{1, 2, 3, 4}));
        System.out.println("result : " + increasingTriplet2(new int[]{1, 2, 3, 4}));
    }


    public boolean increasingTriplet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            boolean find = false;
            for(List<Integer> sList : list){
                int size = sList.size();
                if(size == 1){
                    if(num > sList.get(0)){
                        find = true;
                        sList.add(num);
                    } else if(num < sList.get(0)){
                        sList.remove(0);
                        sList.add(num);
                        find = true;
                    } else {
                        break;
                    }
                } else if(size == 2){
                    if(num > sList.get(1)){
                        return true;
                    }
                    if(num < sList.get(1) && num > sList.get(0)){
                        sList.remove(1);
                        sList.add(num);
                        find = true;
                    }
                    if(num == sList.get(1) || num == sList.get(0)){
                        find = true;
                        continue;
                    }
                }
            }
            if(!find){
                List<Integer> sList = new ArrayList<>();
                sList.add(num);
                list.add(sList);
            }
        }
        for(List<Integer> sList : list){
            System.out.println(sList.toString());
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= first){
                first = nums[i];
            } else if(nums[i] <= second){
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
