package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Q909_SnakesandLadders {

    @Test
    void test() {
        int[][] board1 = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        Assertions.assertEquals(4, snakesAndLadders(board1));

        int[][] board2 = {
            {-1, -1},
            {-1, 3}
        };
        Assertions.assertEquals(1, snakesAndLadders(board2));
    }

    public int snakesAndLadders(int[][] board) {
        // 최대 400번까지 있음
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        int n = board.length;
        int end = n * n;
        
        visited[n-1][0] = true; // 시작점 방문 처리

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int num = arr[0];
            int count = arr[1];

            if(num == end){
                return count;
            }

            for(int i = 1; i <= 6; i++){
                int nextNum = num + i;
                if(nextNum > end) continue;

                int[] pos = getCoords(nextNum, n);
                int r = pos[0];
                int c = pos[1];

                // 사다리나 뱀이 있으면 이동
                int dest = board[r][c] != -1 ? board[r][c] : nextNum;

                // 목적지 좌표 다시 계산 (방문 체크용)
                int[] destPos = getCoords(dest, n);
                
                // 방문하지 않은 칸만 큐에 추가
                // 주의: 여기서 방문 체크는 '도착한 칸' 기준이어야 함
                // 하지만 BFS 특성상 '어떤 숫자에 도달했는지'를 체크하는 것이 더 직관적일 수 있음
                // 여기서는 dest 값 자체를 방문했는지 체크하는 것이 아니라,
                // dest에 해당하는 보드 위치를 방문했는지 체크해야 함.
                // 하지만 문제 특성상 같은 숫자에 도달하면 최단거리가 아니므로
                // dest 값에 대한 방문 체크가 필요함.
                // 기존 visited 배열은 좌표 기준이므로 destPos를 사용
                
                if(!visited[destPos[0]][destPos[1]]){
                    visited[destPos[0]][destPos[1]] = true;
                    queue.add(new int[]{dest, count+1});
                }
            }
        }

        return -1;
    }

    // 숫자를 행렬의 (r, c) 인덱스로 변환하는 핵심 함수
    private int[] getCoords(int num, int n) {
        int rFromBottom = (num - 1) / n; // 아래서부터 몇 번째 행인지 (0부터 시작)
        int r = n - 1 - rFromBottom;      // 실제 배열의 행 인덱스

        int c = (num - 1) % n;           // 열 위치 계산

        // 아래서부터 홀수 번째 행(인덱스 1, 3, 5...)은 오른쪽에서 왼쪽으로 진행
        if (rFromBottom % 2 != 0) {
            c = n - 1 - c;
        }

        return new int[]{r, c};
    }
}
