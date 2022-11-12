package com.app.leetcode;

import com.app.Solution;

import java.util.Stack;

// https://leetcode.com/problems/search-suggestions-system/

public class SearchSuggestionsSystem implements Solution {
    @Override
    public void execute() {

    }

    class TrieNode {
        TrieNode[] nodes;
        boolean isWord;
        String word;

        public TrieNode() {
            this.nodes = new TrieNode[26];
            this.isWord = false;
            this.word = null;
        }

        public boolean hasCharacter(Character c) {
            if (this.nodes[c.charValue()-'a'] != null) {
                return true;
            }
            return false;
        }

        public void addCharacter(Character c) {

        }

    }


}
