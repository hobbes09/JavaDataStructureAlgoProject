package com.app.leetcode;

import com.app.Solution;

import java.util.HashMap;

public class MinimumWindowSubstring implements Solution {
    @Override
    public void execute() {


        String S = "ADOBECODEBANC";
        String T = "ABC";

        HashMap<Character, Integer> requiredCharacters = new HashMap<>();
        HashMap<Character, Integer> currentCharacters = new HashMap<>();
        int totalRequiredChars = T.length();
        int totalCurrentChars = 0;
        for (Character c : T.toCharArray()) {
            requiredCharacters.put(c, requiredCharacters.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int minWindow = S.length() + 1;
        for (; end < S.length(); end++) {
            if (totalCurrentChars < totalRequiredChars) {

            } else {
                while (totalCurrentChars >= totalCurrentChars) {
                    Character c = S.charAt(start);
                    if (currentCharacters.containsKey(c)) {

                    }
                    start++;
                }
            }
        }




    }

    private String stringAtPosition(String str, int pos) {
        return String.valueOf(str.charAt(pos));
    }
}


/*

        HashMap<String, Integer> requiredChars = new HashMap<>();
        HashMap<String, Integer> currentChars = new HashMap<>();

        String S = "ADOBECODEBANC";
        String T = "ABC";

        for (int i = 0; i < T.length(); i++) {
            if (requiredChars.containsKey(stringAtPosition(T, i))) {
                int count = requiredChars.get(stringAtPosition(T, i));
                requiredChars.put(stringAtPosition(T, i), ++count);
            } else {
                requiredChars.put(stringAtPosition(T, i), 1);
                currentChars.put(stringAtPosition(T, i), 0);
            }
        }




 */