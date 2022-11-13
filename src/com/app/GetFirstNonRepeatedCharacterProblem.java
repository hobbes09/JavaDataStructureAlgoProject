package com.app;

import com.app.Solution;

import java.util.HashMap;

public class GetFirstNonRepeatedCharacterProblem implements Solution {

    public Character getFirstNonRepeatedCharacter(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return null;
    }

    @Override
    public void execute() {
        System.out.println(getFirstNonRepeatedCharacter("bacbac"));
    }
}
