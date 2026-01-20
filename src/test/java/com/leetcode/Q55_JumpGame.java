package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q55_JumpGame {

    @Test
    void test() {
        Assertions.assertTrue(canJump(new int[]{2,3,1,1,4}));
        Assertions.assertFalse(canJump(new int[]{3,2,1,0,4}));

        Assertions.assertTrue(canJump2(new int[]{2,3,1,1,4}));
        Assertions.assertFalse(canJump2(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        // 걍 DFS 로 풀자
        int idx = 0;
        return jump(nums, idx);
    }

    private boolean jump(int[] nums, int idx){
        if(idx == nums.length - 1){
            return true;
        } else if(idx >= nums.length){
            return false;
        }

        int max = nums[idx];
        for(int i = max; i > 0; i--){
            if(jump(nums, idx+i)){
                return true;
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        // 마지막 인덱스를 초기 목표로 설정
        int goal = nums.length - 1;

        // 뒤에서부터 앞으로 이동하며 확인
        for (int i = nums.length - 2; i >= 0; i--) {
            // 현재 위치(i)에서 최대 점프(nums[i])가 목표 지점에 닿는다면
            if (i + nums[i] >= goal) {
                // 목표 지점을 현재 위치로 갱신 (더 앞으로 당김)
                goal = i;
            }
        }

        // 최종적으로 목표가 0번 인덱스까지 도달했는지 확인
        return goal == 0;
    }

}
