package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q955_DeleteColumnstoMakeSorted2 {

    @Test
    void test() {
        Assertions.assertEquals(1, minDeletionSize(new String[]{"ca","bb","ac"}));
        Assertions.assertEquals(minDeletionSize(new String[]{"xc","yb","za"}),0 );
        Assertions.assertEquals(minDeletionSize(new String[]{"zyx","wvu","tsr"}),3 );
    }

    // #greedy
    public int minDeletionSize(String[] strs) {
        // [1] 이 true 라면 [0]은 [1]보다 작기 때문에 신경 쓸 필요가 없음 이라는 뜻
        boolean[] isSorted = new boolean[strs.length];

        int answer = 0;
        // "abcdef" 가 있다면 "a"부터 시작
        for(int i = 0; i < strs[0].length(); i++){
            boolean[] curSorted = new boolean[strs.length];
            boolean isDel = false;
            for(int s = 1; s < strs.length; s++){
                if(!isSorted[s]){
                    if(strs[s].charAt(i) < strs[s-1].charAt(i)){
                        isDel = true;
                        break;
                    } else if(strs[s].charAt(i) > strs[s-1].charAt(i)){
                        curSorted[s] = true;
                    }
                }
            }
            if(isDel){
                answer++;
            } else {
                for(int j = 1; j < strs.length; j++){
                    isSorted[j] = isSorted[j] || curSorted[j];
                }
            }
            boolean isComplete = true;
            for(int j = 1; j < strs.length; j++){
                if(!isSorted[j]){
                    isComplete = false;
                }
            }
            if(isComplete){
                return answer;
            }
        }

        return answer;
    }
}
