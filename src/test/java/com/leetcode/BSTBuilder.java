package com.leetcode;

public class BSTBuilder {

    private TreeNode root;

    public BSTBuilder() {
        this.root = null;
    }

    // 배열의 모든 값을 BST에 삽입하는 메서드
    public void buildTree(int[] values) {
        for (int value : values) {
            root = insert(root, value);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    // 재귀적으로 값을 삽입하는 메서드
    private TreeNode insert(TreeNode node, int value) {
        // 1. 현재 노드가 null이면 새로운 노드를 생성하여 반환
        if (node == null) {
            return new TreeNode(value);
        }

        // 2. 현재 노드의 값과 삽입할 값을 비교하여 위치 결정
        if (value < node.val) {
            // 삽입할 값이 현재 노드보다 작으면 왼쪽 서브트리로 이동
            node.left = insert(node.left, value);
        } else if (value > node.val) {
            // 삽입할 값이 현재 노드보다 크면 오른쪽 서브트리로 이동
            node.right = insert(node.right, value);
        }

        // 3. 현재 노드를 반환하여 부모 노드의 자식으로 연결
        return node;
    }

    // 구축된 트리를 시각적으로 확인하기 위한 중위 순회(in-order traversal) 메서드
    public void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}