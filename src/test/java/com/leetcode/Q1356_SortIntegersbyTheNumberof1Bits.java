package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Q1356_SortIntegersbyTheNumberof1Bits {

    @Test
    void test() {
        System.out.println("result : " + Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println("result : " + Arrays.toString(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));

        System.out.println("result : " + Arrays.toString(sortByBits2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println("result : " + Arrays.toString(sortByBits2(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }

    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i : arr) {
            int cnt = Integer.bitCount(i);
            List<Integer> list = map.getOrDefault(cnt, new ArrayList<>());
            list.add(i);
            map.put(cnt, list);
        }

        int idx = 0;
        for (Integer i : map.keySet()) {
            List<Integer> list = map.get(i);
            for (int l : list) {
                arr[idx] = l;
                idx++;
            }
        }

        return arr;
    }

    public int[] sortByBits2(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted((o1, o2) -> {
                    int b1 = Integer.bitCount(o1);
                    int b2 = Integer.bitCount(o2);
                    if(b1 != b2){
                        return b1 - b2;
                    }
                    return o1 - o2;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
