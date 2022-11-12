package com.app.reference.graph;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TopologicalSortWithCycleDetection {

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    int totalNodes;
    LinkedList<Integer> adjList[];
    private Integer states[];
    private boolean isCyclic = false;

    public TopologicalSortWithCycleDetection(int totalNodes) {
        this.totalNodes = totalNodes;
        this.adjList = new LinkedList[totalNodes];
        this.states = new Integer[this.totalNodes];
        for (int i=0; i<totalNodes; i++) {
            this.adjList[i] = new LinkedList<>();
            this.states[i] = WHITE;
        }
    }

    private void refreshStates() {
        for (int i=0; i<totalNodes; i++) {
            this.states[i] = WHITE;
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

        refreshStates();
        Deque<Integer> stack = new LinkedList<>();

        for (int i=0; i<this.totalNodes; i++) {
            if (this.states[i] == WHITE) {
                sortUtil(i, stack);
            }
        }

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(stack.pop() + " --> ");
        }
    }

    private void sortUtil(int s, Deque<Integer> stack) {

        if (this.isCyclic) {
            return;
        }
        this.states[s] = GRAY;
        Iterator<Integer> iterator = this.adjList[s].iterator();
        while (iterator.hasNext()) {
            Integer t = iterator.next();
            if (this.states[t] == WHITE) {
                sortUtil(t, stack);
            } else if (this.states[t] == GRAY) {
                this.isCyclic = true;
            }
            // Don't visit in case of BLACK, its already fully explored
        }
        this.states[s] = BLACK;
        stack.push(s);
    }

}
