package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Q17_LetterCombinationsonaPhoneNumber {

    @Test
    void test() {
        System.out.println("result : " + maxDepth(new TreeNode(1)));
    }

    public int maxDepth(TreeNode root) {
        return 1;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        list.add(digits);
        int repeat = digits.length();
        for(int i = 0; i < repeat; i++){
            char c = digits.charAt(i);
            if(c == '2'){
                // list.add();
            } else if(c == '3'){

            } else if(c == '4'){

            } else if(c == '5'){

            } else if(c == '6'){

            } else if(c == '7'){

            } else if(c == '8'){

            } else if(c == '9'){

            }
        }

        for(char c : digits.toCharArray()){
            if(c == '2'){

            } else if(c == '3'){

            } else if(c == '4'){

            } else if(c == '5'){

            } else if(c == '6'){

            } else if(c == '7'){

            } else if(c == '8'){

            } else if(c == '9'){

            }
        }
        return list;
    }
}
