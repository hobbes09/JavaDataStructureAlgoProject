package com.app.reference.graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleGraph {

    int totalNodes;
    LinkedList<Integer> adjList[];

    public SimpleGraph(int totalNodes) {
        this.totalNodes = totalNodes;
        this.adjList = new LinkedList[totalNodes];
        for (int i=0; i<totalNodes; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) throws Exception {
        if(from<0 || from>=this.totalNodes || to<0 || to>=this.totalNodes) {
            throw new Exception("Invalid Input");
        }

        LinkedList<Integer> nodeAdj = adjList[from];
        if (!nodeAdj.contains(to)) {
            nodeAdj.add(to);
        }
    }

    public void bfs(int s) throws Exception {
        if (s<0 || s>=this.totalNodes) {
            throw new Exception("Invalid input");
        }

        Deque<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[this.totalNodes];
        for (int i=0; i<this.totalNodes; i++) {
            visited[i] = false;
        }

        queue.add(s);
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            if (!visited[node]) {
                // mark visited
                visited[node] = true;
                // print
                System.out.print(node + " --> ");

                // add nodes to queue
                Iterator<Integer> iterator = this.adjList[node].iterator();
                while (iterator.hasNext()) {
                    Integer t = iterator.next();
                    if (!visited[t]) {
                        queue.add(t);
                    }
                }
            }
        }
    }

    public void dfs(int s) throws Exception {
        if (s<0 || s>=this.totalNodes) {
            throw new Exception("Invalid input");
        }

        boolean visited[] = new boolean[this.totalNodes];
        for (int i=0; i<this.totalNodes; i++) {
            visited[i] = false;
        }
        dfsUtil(s, visited);
    }

    public void dfsUtil(int s, boolean[] visited) {

        visited[s] = true;
        System.out.print(s + " --> ");

        Iterator<Integer> iterator = adjList[s].iterator();
        while (iterator.hasNext()) {
            Integer t = iterator.next();
            if (!visited[t]) {
                dfsUtil(t, visited);
            }
        }
    }
}
