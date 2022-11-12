package com.app.reference;

import java.util.LinkedList;

public class GraphNode {
    int value;
    boolean isVisited;
    LinkedList<GraphNode> adjacencyList;

    public GraphNode(int value) {
        this.value = value;
        this.isVisited = false;
        this.adjacencyList = new LinkedList<>();
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void markVisited() {
        this.isVisited = true;
    }
}
