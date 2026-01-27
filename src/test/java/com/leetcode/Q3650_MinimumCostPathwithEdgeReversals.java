package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Q3650_MinimumCostPathwithEdgeReversals {

    @Test
    void test() {
        Assertions.assertEquals(10, minCost(3, new int[][]{{0, 1, 5}, {1, 2, 5}}));
        Assertions.assertEquals(9, minCost(3, new int[][]{{0, 1, 5}, {2, 1, 2}}));
        Assertions.assertEquals(4, minCost(4, new int[][]{{0, 1, 1}, {2, 1, 1}, {2, 3, 1}}));
        Assertions.assertEquals(-1, minCost(3, new int[][]{{0, 1, 1}}));
    }

    public int minCost(int n, int[][] edges) {
        // 최단 거리라고 답인 것은 아니야
        // 각각의 노드에 도착하는 최단 거리
        int[] min = new int[n];
        // min[n-1] 의 최소값 구하기
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            List<Node> list = map.getOrDefault(edges[i][0], new ArrayList<>());
            list.add(new Node(edges[i][1], edges[i][2]));
            map.put(edges[i][0], list);

            list = map.getOrDefault(edges[i][1], new ArrayList<>());
            list.add(new Node(edges[i][0], edges[i][2] * 2));
            map.put(edges[i][1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int idx = queue.poll();
            if(map.containsKey(idx)){
                for(Node node : map.get(idx)){
                    if(min[node.dest] == 0){
                        min[node.dest] = min[idx] + node.cost;
                        queue.add(node.dest);
                    } else {
                        if(min[node.dest] > min[idx] + node.cost){
                            min[node.dest] = min[idx] + node.cost;
                            queue.add(node.dest);
                        }
                    }
                }
            }
        }

        return min[n-1] == 0 ? -1 : min[n-1];
    }

    public class Node {
        int dest;
        int cost;
        public Node (int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
    }

}
