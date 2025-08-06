package com.app.reference.graph;

import com.app.Solution;

import java.util.*;

public class BFSShortestPath implements Solution {

    @Override
    public void execute() {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(0, 3, 4));
        graph.put(3, Arrays.asList(1, 2, 5));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(3));

        int source = 0;
        bfsShortestPath(graph, source);

    }

    public static void bfsShortestPath(Map<Integer, List<Integer>> graph, int source) {
        int n = graph.size(); // assuming nodes are labeled from 0 to n-1 or similar
        int[] distance = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        distance[source] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    parent[neighbor] = current;
                    queue.offer(neighbor);
                }
            }
        }

        // Print distances and paths
        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + " is unreachable from source " + source);
            } else {
                System.out.print("Shortest distance to node " + i + ": " + distance[i]);
                System.out.print(" | Path: ");
                printPath(i, parent);
                System.out.println();
            }
        }
    }

    private static void printPath(int target, int[] parent) {
        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.print(path);
    }
}
