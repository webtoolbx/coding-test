package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

import org.junit.jupiter.api.Test;

public class Q208_ImplementTrie {

    @Test
    void test() {
        System.out.println("result : ");
    }

    class Trie {

        Map<Character, Set<String>> map;
        public Trie() {
            map = new HashMap<>();
        }

        public void insert(String word) {
            Set<String> set = map.getOrDefault(word.charAt(0), new HashSet<>());
            set.add(word);
            map.put(word.charAt(0), set);
        }

        public boolean search(String word) {
            return map.containsKey(word.charAt(0)) && map.get(word.charAt(0)).contains(word);
        }

        public boolean startsWith(String prefix) {
            return map.containsKey(prefix.charAt(0)) && map.get(prefix.charAt(0)).stream().anyMatch(v -> v.startsWith(prefix));
        }
    }

}
