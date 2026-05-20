package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q2657 {

    @Test
    void testFindThePrefixCommonArray() {
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        int[] expected1 = {0, 2, 3, 4};
        int[] actual1 = findThePrefixCommonArray(A1, B1);
        Assertions.assertArrayEquals(expected1, actual1);

        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        int[] expected2 = {0, 1, 3};
        int[] actual2 = findThePrefixCommonArray(A2, B2);
        Assertions.assertArrayEquals(expected2, actual2);

        int[] actual3 = findThePrefixCommonArray2(A1, B1);
        Assertions.assertArrayEquals(expected1, actual3);

        int[] actual4 = findThePrefixCommonArray2(A2, B2);
        Assertions.assertArrayEquals(expected2, actual4);
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // 공통인 수의 숫자 구하기
        // 둘의 길이는 동일함
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int[] result = new int[A.length];
        if(A[0] == B[0]){
            result[0] = 1;
        }
        setA.add(A[0]);
        setB.add(B[0]);
        for(int i = 1; i < A.length; i++){
            int a = A[i];
            int b = B[i];

            int cnt = result[i-1];
            if(setB.contains(a)){
                cnt++;
            }
            setA.add(a);
            if(setA.contains(b)){
                cnt++;
            }
            setB.add(b);
            result[i] = cnt;
        }

        return result;
    }

    public int[] findThePrefixCommonArray2(int[] A, int[] B) {
        // 공통인 수의 숫자 구하기
        // 둘의 길이는 동일함
        // 근데 비트 연산으로도 가능할거 같아

        int size = A.length;
        long bitA = 0L;
        long bitB = 0L;

        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            int a = A[i];
            int b = B[i];
            bitA = bitA | (1L << a);
            bitB = bitB | (1L << b);

            result[i] = Long.bitCount(bitA & bitB);
        }

        return result;
    }
}