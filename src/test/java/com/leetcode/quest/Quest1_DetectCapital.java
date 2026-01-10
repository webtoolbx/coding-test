package com.leetcode.quest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Quest1_DetectCapital {

    @Test
    void test() {
        Assertions.assertEquals(true, detectCapitalUse("USA"));
        Assertions.assertEquals(false, detectCapitalUse("FlaG"));
    }

    // #String
    public boolean detectCapitalUse(String word) {
        String upperCase = word.toUpperCase();
        String lowerCase = word.toLowerCase();

        return word.equals(upperCase) || word.equals(lowerCase) || (upperCase.charAt(0) + lowerCase.substring(1)).equals(word);
    }
}
