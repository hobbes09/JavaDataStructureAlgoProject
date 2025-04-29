package com.app.leetcode;

import com.app.Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubstring implements Solution {
    @Override
    public void execute() {


        String longStr = "ADOBECODEBANC";
        String smallStr = "ABC";

        HashMap<Character, Integer> requiredFreqCount = new HashMap<>();
        HashMap<Character, Integer> currentFreqCount = new HashMap<>();

        for (Character c : smallStr.toCharArray()){
            requiredFreqCount.put(c, requiredFreqCount.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int requiredCount = smallStr.length();
        int currentCount = 0;
        int minWindow = Integer.MAX_VALUE;
        while (start < longStr.length() && end < longStr.length()){
            if (currentCount < requiredCount) {
                if (end < longStr.length()) {
                    Character currChar = longStr.charAt(end);
                    if (requiredFreqCount.containsKey(currChar) && currentFreqCount.getOrDefault(currChar, 0) < requiredFreqCount.get(currChar)) {
                        // Found a required character
                        currentFreqCount.put(currChar, currentFreqCount.getOrDefault(currChar, 0) + 1);
                        currentCount++;
                    }
                    end++;
                } else {
                    break;
                }
            } else {
                minWindow = (end-start < minWindow) ? end-start : minWindow;
                while(start < end) {
                    start++;
                    Character remChar = longStr.charAt(start);
                    if (requiredFreqCount.containsKey(remChar)){
                        currentCount--;
                        currentFreqCount.put(remChar, currentFreqCount.getOrDefault(remChar, 1) - 1);
                        break;
                    }
                }
            }
        }

        if (currentCount < requiredCount)
            System.out.println("");
    }
}