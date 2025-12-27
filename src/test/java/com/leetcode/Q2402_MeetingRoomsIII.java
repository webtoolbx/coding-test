package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2402_MeetingRoomsIII {
    // PriorityQueue가 간단은 한데 좀 느리네

    @Test
    void test() {
        Assertions.assertEquals(0, mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        Assertions.assertEquals(1, mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));

        Assertions.assertEquals(0, mostBooked2(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));
        Assertions.assertEquals(1, mostBooked2(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
    }

    public int mostBooked(int n, int[][] meetings) {
        // 1. 시작 시간 기준으로 정렬 (필수)
        Arrays.sort(meetings, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 각 방이 언제 비는지 '종료 시각'을 저장 (int 범위를 넘을 수 있어 long 권장)
        long[] roomEnds = new long[n];
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            boolean found = false;
            int earliestRoom = 0;
            long minEndTime = Long.MAX_VALUE;

            // 2. 현재 회의가 바로 들어갈 수 있는 빈 방이 있는지 확인 (낮은 번호 우선)
            for (int i = 0; i < n; i++) {
                if (roomEnds[i] <= start) {
                    roomEnds[i] = end; // 즉시 시작 가능하므로 원래 종료 시간 입력
                    count[i]++;
                    found = true;
                    break;
                }

                // 빈 방이 없을 경우를 대비해 가장 빨리 비는 방을 기록해둠
                if (roomEnds[i] < minEndTime) {
                    minEndTime = roomEnds[i];
                    earliestRoom = i;
                }
            }

            // 3. 바로 들어갈 수 있는 방이 없다면, 가장 빨리 비는 방을 기다렸다가 들어감
            if (!found) {
                // 이 방이 비는 시점(minEndTime)에 시작해서 원래 기간(duration)만큼 진행
                roomEnds[earliestRoom] = minEndTime + duration;
                count[earliestRoom]++;
            }
        }

        // 4. 가장 많이 사용된 방 찾기 (동점일 경우 낮은 번호)
        int ans = 0;
        int maxCount = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                ans = i;
            }
        }

        return ans;
    }

    // #PriorityQueue
    public int mostBooked2(int n, int[][] meetings) {
        // 정렬 처리
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> availRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) availRooms.add(i);

        // 종료시간, index - 종료시간 우선, index 오름차순
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) ->
                a[0] == b[0] ? (int)(a[1] - b[1]) : Long.compare(a[0], b[0]));

        int[] count = new int[n];
        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];

            // 회의 시작 전에 busyRooms 에서 회의가 끝난 방들 복구
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start){
                long[] curRoom = busyRooms.poll();
                availRooms.add((int)curRoom[1]);
            }

            // 빈 방이 있는 경우
            if(!availRooms.isEmpty()){
                int idx = availRooms.poll();
                busyRooms.add(new long[]{end, idx});
                count[idx]++;
            } else {
                // 기다렸다가 방에 들어가는 경우
                long[] curRoom = busyRooms.poll();
                // 종료시간 + 원래시간
                busyRooms.add(new long[]{curRoom[0] + end - start, curRoom[1]});
                count[(int)curRoom[1]]++;
            }

        }

        //count 계산해서 리턴
        int ans = 0;
        int max = -1;
        for(int i = 0; i < n; i++){
            if(count[i] > max){
                max = count[i];
                ans = i;
            }
        }

        return ans;
    }
}
