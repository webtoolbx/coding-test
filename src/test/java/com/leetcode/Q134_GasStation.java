package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q134_GasStation {

    @Test
    void test() {
        Assertions.assertEquals(3, canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        Assertions.assertEquals(-1, canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));

        Assertions.assertEquals(3, canCompleteCircuit2(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        Assertions.assertEquals(-1, canCompleteCircuit2(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            gas[i] = gas[i] - cost[i];
        }
        if(check(0, gas)){
            return 0;
        }
        for(int i = 1; i < gas.length; i++){
            if(gas[i] <= gas[i-1]){
                continue;
            }
            if(check(i, gas)){
                return i;
            }
        }

        return -1;
    }
    private boolean check(int i, int[] gas){
        if(gas[i] < 0) return false;
        int idx = i+1;
        if(idx == gas.length){
            idx = 0;
        }

        int tank = gas[i];
        while(idx != i){
            tank += gas[idx];
            if(tank < 0) return false;
            idx++;
            if(idx == gas.length){
                idx = 0;
            }
        }
        return true;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int totalGas = 0;   // 총량
        int curGas = 0;     // 현재 가스값
        int start = 0;      // 시작 지점

        for (int i = 0; i < gas.length; i++){
            int remain = gas[i] - cost[i];
            totalGas += remain;
            curGas += remain;

            if (curGas < 0) { // 음수가 될 경우 실패
                curGas = 0;
                start = i + 1;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
