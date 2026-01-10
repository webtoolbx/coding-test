package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q392_IsSubsequence {

    @Test
    void test() {
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("axc", "ahbgdc"));
        Assertions.assertTrue(isSubsequence("", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("abc", ""));

        Assertions.assertTrue(isSubsequence2("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence2("axc", "ahbgdc"));
        Assertions.assertTrue(isSubsequence2("", "ahbgdc"));
        Assertions.assertFalse(isSubsequence2("abc", ""));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        if(sArr.length == 0) return true;
        if(tArr.length == 0) return false;

        int i1 = 0;
        int i2 = 0;

        while(i2 < tArr.length){
            if(sArr[i1] == tArr[i2]){
                i1++;
                i2++;
            } else {
                i2++;
            }

            if(i1 == sArr.length){
                return true;
            }
        }

        return false;
    }

    public boolean isSubsequence2(String s, String t) {
        // t에 있는 내용을 삭제해서 s를 만들 수 있는가?
        // s 에 있는 데이터가 t에 꼭 있어야함
        // 근데 이게 순차니까 idx1, idx2 를 두고서 비교해보면 될거 같아.

        int idx = 0;
        int l1 = s.length();
        int l2 = t.length();
        // while 보다 안전하게 for문으로 가자
        for(int i = 0; i < l1; i++){
            boolean match = false;
            while(idx < l2){
                if(s.charAt(i) == t.charAt(idx)){
                    match = true;
                    break;
                }
                idx++;
            }
            if(match){
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }

}
