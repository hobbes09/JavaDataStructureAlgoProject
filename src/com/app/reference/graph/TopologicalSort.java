package com.app.reference.graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TopologicalSort {

    int totalNodes;
    LinkedList<Integer> adjList[];

    public TopologicalSort(int totalNodes) {
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

    public void topologicalSort() {

         Deque<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[this.totalNodes];

        for (int i=0; i<this.totalNodes; i++) {
            if (!visited[i]) {
                sortUtil(i, visited, stack);
            }
        }

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(stack.pop() + " --> ");
        }
    }

    private void sortUtil(int s, boolean[] visited, Deque<Integer> stack) {

        visited[s] = true;
        Iterator<Integer> iterator = this.adjList[s].iterator();
        while (iterator.hasNext()) {
            Integer t = iterator.next();
            if (!visited[t]) {
                sortUtil(t, visited, stack);
            }
        }
        stack.push(s);
    }
}
