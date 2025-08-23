package com.leetcode;

import org.junit.jupiter.api.Test;

public class Q3195_FindtheMinimumAreatoCoverAllOnesI {

    @Test
    void test() {
        System.out.println("result : " + minimumArea1(new int[][]{{0,1,0},{1,0,1}}));
    }

    public int minimumArea1(int[][] grid) {
        // min x, max x, min y, max y
        int[] nums = new int[]{grid[0].length, -1, grid.length, -1};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(i < nums[0]){
                        nums[0] = i;
                    }
                    if(i > nums[1]){
                        nums[1] = i;
                    }
                    if(j < nums[2]){
                        nums[2] = j;
                    }
                    if(j > nums[3]){
                        nums[3] = j;
                    }
                }
            }
        }
        return (nums[1] - nums[0] + 1) * (nums[3] - nums[2] + 1);
    }

}
