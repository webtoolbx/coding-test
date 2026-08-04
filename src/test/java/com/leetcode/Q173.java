package com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Q173 {

    @Test
    void BSTIterator() {
    }

    class BSTIterator {
        Deque<TreeNode> queue;
        public BSTIterator(TreeNode root) {
            queue = new ArrayDeque<TreeNode>();
            order(root);
        }
        private void order(TreeNode node){
            if(node == null) return;
            order(node.left);
            queue.addLast(node);
            order(node.right);
        }
        public int next() {
            // 현재 노드에서 왼쪽
            // 현재 노드에서 오른쪽
            return queue.removeFirst().val;
        }
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}