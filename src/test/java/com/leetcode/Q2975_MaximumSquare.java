package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q2975_MaximumSquare {

    @Test
    void test() {
        Assertions.assertEquals(4, maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
        Assertions.assertEquals(-1, maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        // 가능한 x 값들
        // 가능한 y 값들
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        int[] v = new int[vFences.length + 2];
        v[0] = 1;
        for(int i = 0; i < vFences.length; i++){
            v[i+1] = vFences[i];
        }
        v[vFences.length+1] = n;

        int[] h = new int[hFences.length + 2];
        h[0] = 1;
        for(int i = 0; i < hFences.length; i++){
            h[i+1] = hFences[i];
        }
        h[hFences.length+1] = m;

        Set<Integer> xSet = new HashSet<>();
        for(int i = 0; i < v.length; i++){
            for(int j = i+1; j < v.length; j++){
                xSet.add(v[j] - v[i]);
            }
        }
        Set<Integer> ySet = new HashSet<>();
        for(int i = 0; i < h.length; i++){
            for(int j = i+1; j < h.length; j++){
                ySet.add(h[j] - h[i]);
            }
        }

        // Array 로 정렬하기
        List<Integer> list1 = new ArrayList<>(xSet);

        long maxSide = -1;
        long mod = 1_000_000_007;
        Collections.sort(list1, Collections.reverseOrder());
        for(int i : list1){
            if(ySet.contains(i)){
                maxSide = i;
                break;
            }
        }

        if (maxSide == -1) return -1;
        return (int) ((maxSide * maxSide) % mod);
    }
}
