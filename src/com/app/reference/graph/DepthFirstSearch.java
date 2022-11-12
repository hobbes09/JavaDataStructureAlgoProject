package com.app.reference.graph;

import com.app.Solution;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch implements Solution {

    enum Status {
        white,
        gray,
        black
    };
    LinkedList<Integer>[] adjList;
    Status[] visitedStatus;

    @Override
    public void execute() {

        initGraph(4);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,2);
        addEdge(2,0);
        addEdge(2,3);

        dfs(1);

    }

    private void initGraph(int numNodes) {
        adjList = new LinkedList[numNodes];
        visitedStatus = new Status[numNodes];
        for (int i=0; i<numNodes; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int from, int to) {
        LinkedList<Integer> connections = new LinkedList<>();
        connections = adjList[from];
        if (!connections.contains(to)) {
            connections.add(to);
        }
    }

    private void dfs(int source) {
        for(int i=0; i<visitedStatus.length; i++)
            visitedStatus[i] = Status.white;

        dfsRecursive(source);
        for (int i=0; i<adjList.length; i++) {
            if (visitedStatus[i] == Status.white) {
                dfsRecursive(i);
            }
        }
    }

    private void dfsRecursive(int source) {
        System.out.println(source);
        visitedStatus[source] = Status.gray;
        LinkedList<Integer> edges = adjList[source];
        Iterator<Integer> iterator = edges.iterator();
        while (iterator.hasNext()) {
            Integer node = iterator.next();
            if (visitedStatus[node] == Status.white)
                dfsRecursive(node);
        }
        visitedStatus[source] = Status.black;
    }
}
