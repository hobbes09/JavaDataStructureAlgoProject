package com.app.leetcode;

import com.app.Solution;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/

public class GroupAnagrams implements Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();
        List<List<String>> anagramList = new ArrayList<>();

        for (int i=0; i<strs.length; i++) {
            String signature = getAnagramSignature(strs[i]);
            List<String> anagramsOfThisSignature = anagrams.getOrDefault(signature, new ArrayList<>());
            anagramsOfThisSignature.add(strs[i]);
            anagrams.put(signature, anagramsOfThisSignature);
        }

        Iterator<String> iterator = anagrams.keySet().iterator();
        while(iterator.hasNext()) {
            anagramList.add(anagrams.get(iterator.next()));
        }
        return anagramList;
    }

    private String getAnagramSignature(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    @Override
    public void execute() {
        List<List<String>> anagramList = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(anagramList);
    }
}
