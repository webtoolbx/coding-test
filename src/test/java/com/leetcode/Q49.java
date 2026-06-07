package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q49 {

    @Test
    void test() {
        // This test method is empty, keeping it as is or removing it if it's not needed.
    }

    @Test
    void testGroupAnagrams() {
        Q49 solution = new Q49();

        // Test case 1: Example from LeetCode
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected1 = Arrays.asList(
            Arrays.asList("bat"),
            Arrays.asList("nat", "tan"),
            Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        assertListsOfListsEquals(expected1, result1);

        // Test case 2: Empty array
        String[] strs2 = {};
        List<List<String>> expected2 = Arrays.asList();
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        assertListsOfListsEquals(expected2, result2);

        // Test case 3: Single word array
        String[] strs3 = {"a"};
        List<List<String>> expected3 = Arrays.asList(Arrays.asList("a"));
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        assertListsOfListsEquals(expected3, result3);

        // Test case 4: Words with no anagrams
        String[] strs4 = {"abc", "def", "ghi"};
        List<List<String>> expected4 = Arrays.asList(
            Arrays.asList("abc"),
            Arrays.asList("def"),
            Arrays.asList("ghi")
        );
        List<List<String>> result4 = solution.groupAnagrams(strs4);
        assertListsOfListsEquals(expected4, result4);

        // Test case 5: All words are anagrams of each other
        String[] strs5 = {"listen", "silent", "enlist"};
        List<List<String>> expected5 = Arrays.asList(
            Arrays.asList("listen", "silent", "enlist")
        );
        List<List<String>> result5 = solution.groupAnagrams(strs5);
        assertListsOfListsEquals(expected5, result5);

        // Test case 6: Words with different cases (assuming case-sensitive anagrams)
        // The current solution is case-sensitive because `toCharArray()` and `Arrays.sort()` are.
        String[] strs6 = {"a", "A"};
        List<List<String>> expected6 = Arrays.asList(
            Arrays.asList("a"),
            Arrays.asList("A")
        );
        List<List<String>> result6 = solution.groupAnagrams(strs6);
        assertListsOfListsEquals(expected6, result6);
    }

    // Helper method to compare List<List<String>> ignoring order of inner lists and strings within them
    private void assertListsOfListsEquals(List<List<String>> expected, List<List<String>> actual) {
        Assertions.assertEquals(expected.size(), actual.size(), "Number of anagram groups should be the same.");

        // Sort each inner list
        expected.forEach(Collections::sort);
        actual.forEach(Collections::sort);

        // Sort the outer lists based on the first element of each inner list for consistent comparison
        expected.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        actual.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), actual.get(i), "Anagram group mismatch at index " + i);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
