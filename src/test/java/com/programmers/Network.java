package com.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    @Test
    void test() {
        Network network = new Network();
        Assertions.assertEquals(2, network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1, network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 1 1 0
        // 1 1 0
        // 0 0 1
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                answer++;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    // System.out.println(cur);
                    for(int j = 0; j < n; j++){

                        if(!visited[j] && cur != j && computers[cur][j] == 1){
                            visited[j] = true;
                            queue.add(j);
                        }
                    }
                }
                // System.out.println("한번 종료");
            }
        }

        return answer;
    }
}
