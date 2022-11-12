package com.app.leetcode;

import com.app.Solution;

import java.util.*;

// https://algo.monster/problems/concatenated_string_length_with_unique_characters

public class ConcatenatedStringLengthWithUniqueCharacters implements Solution {
    @Override
    public void execute() {

        String[] arr = {"co","dil","ity"};
        HashSet<Character> characterHashSet = new HashSet<>();
        String out = "";

        TreeMap<Integer, List<String>> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i=0; i<arr.length; i++) {
            int len = arr[i].length();
            List<String> strings = map.get(len);
            if (strings == null)
                strings = new ArrayList<>();
            strings.add(arr[i]);
            map.put(len, strings);
        }

        Map.Entry<Integer, List<String>> entry = map.pollFirstEntry();
        while (entry != null) {
            System.out.println(entry.getKey());
            List<String> words = entry.getValue();

            for(String word : words) {
                boolean exists = false;
                for (Character c : word.toCharArray()) {
                    if (characterHashSet.contains(c)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    out += word;
                    for (Character c : word.toCharArray()) {
                        characterHashSet.add(c);
                    }
                }
            }
            entry = map.pollFirstEntry();
        }

        System.out.println(out);
    }
}
