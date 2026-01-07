package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1339_MaximumProductofSplittedBinaryTree {

    @Test
    void test() {
        System.out.println("result : " + maxProduct(new TreeNode(1)));
    }

    List<Long> list = null;
    public int maxProduct(TreeNode root) {
        // 곱셈이 크게 나오려면 2개의 수가 비슷해야함
        // 모든 숫자들을 합하고, 가장 왼쪽 수부터 진행? 하기에는
        // 간선을 어떻게 자르냐
        // 서브트리의 합
        list = new ArrayList<>();
        long total = getDFS(root);
        long max = 0;
        for(long i : list){
            max = Math.max(max, i * (total - i));
        }

        return (int) (max % 1000000007);
    }

    public long getDFS(TreeNode node){
        long left = node.left != null ? getDFS(node.left) : 0;
        long right = node.right != null ? getDFS(node.right): 0;
        long sum = node.val + left + right;
        list.add(sum);
        return sum;
    }
}
