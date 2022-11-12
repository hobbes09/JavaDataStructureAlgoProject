package com.app.leetcode;

import com.app.Solution;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters implements Solution {

    private HashMap<Character, Integer> charLocations = new HashMap<>();
    private int start = 0, end = 0, max = 1;

    @Override
    public void execute() {

        String str =  "abcdcbdeadf";

        if (str.length() == 0) {
            System.out.println("0");
            return;
        }

        while (end < str.length()) {
            Character ch = str.charAt(end);
            if (isCurrentStringContainsCharacter(ch)) {
                start = charLocations.get(ch) + 1;
            } else {
                if (end - start + 1 > max)
                    max = end - start + 1;
            }
            charLocations.put(ch, end);
            end++;
        }

        System.out.println(max);
    }

    private boolean isCurrentStringContainsCharacter(Character ch) {
        if (charLocations.containsKey(ch)) {
            if (charLocations.get(ch) >= start) {
                return true;
            }
        }
        return false;
    }


}
