package com.app.reference.graph;

import com.app.Solution;

import java.util.*;

/*
https://leetcode.com/problems/alien-dictionary/discuss/70169/My-Concise-JAVA-solution-based-on-Topological-Sorting
 */
public class AlienDictionary implements Solution {

    @Override
    public void execute() {
        String out = alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        System.out.println(out);
    }

    class Point {
        int x, y;
        public Point() {
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String alienOrder(String[] words) {
        List<Point> pairs = new LinkedList<Point>(); // Adjacency list: pair = (node, node's predecessor)
        Set<Character> chs = new HashSet<Character>();// All distinct characters

        // 1. Convert characters to a graph: Adjacency lists
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean alreadySet = false;// Only set one pair where the characters at the same position differs in two neighbor rows. e.g. "wrtk" < "wrfp"=> 't' < 'f'
            for (int j = 0; j < words[i].length(); j++) {
                if (!alreadySet && i > 0 && j < words[i-1].length() && words[i].charAt(j) != words[i-1].charAt(j)) {// Set dependency of two characters by comparing two neighbor rows.
                    pairs.add(new Point(words[i].charAt(j), words[i-1].charAt(j)));
                    alreadySet = true;
                }
                chs.add(word.charAt(j));// Add distinct character to chs set
            }
        }

        // 2. Topological sorting: keep adding elements whose in-degree is 0
        String res = "";
        int indegree[] = new int[256];
        Arrays.fill(indegree, Integer.MIN_VALUE);

        for (Character ch : chs) indegree[ch] = 0;// Initialize in-degree of the distinct characters in the words list
        for (int i = 0; i < pairs.size(); i++)// Increase in-degree according to the dependency of pairs list
            indegree[pairs.get(i).x]++;

        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < 256; i++) {
            if (indegree[i] == 0) {// Add the character whose in-degree = 0, which means it doesn't have any predecessor
                res += (char) i;
                queue.offer((char) i);
            }
        }

        while (!queue.isEmpty()) {
            Character predecessor = queue.poll(); // Dequeue the character whose in-degree = 0 from queue

            for (int i = 0; i < pairs.size(); i++) {
                if (pairs.get(i).y == predecessor) {// Update in-degree: decrease 1 to the successors of the character whose in-degree = 0
                    indegree[pairs.get(i).x]--;
                    if (indegree[pairs.get(i).x] == 0) {// If in-degree = 0, add the character to the queue, and append it to the result string
                        res += (char) pairs.get(i).x;
                        queue.offer((char) pairs.get(i).x);
                    }
                }
            }
        }
        return res.length() == chs.size() ? res : "";// NOTE: res.length should equal the size of distinct characters, otherwise a cycle must exist
    }
}
