package com.leetcode;

import com.sun.source.doctree.SeeTree;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q2215_FindTheDifferenceOfTwoArrays {

    @Test
    void test() {
        System.out.println("result : " + findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println("result : " + findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> result = new ArrayList<>();
        result.add(set1.stream()
            .filter(Predicate.not(set2::contains))
            .toList());
        result.add(set2.stream()
            .filter(Predicate.not(set1::contains))
            .toList());

        return result;
    }
}
