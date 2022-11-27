package com.app.reference.graph;

import java.util.LinkedList;

public class GraphNode {
    int value;
    boolean isVisited;
    GraphNodeState state;
    LinkedList<GraphNode> adjacencyList;

    public GraphNode(int value) {
        this.value = value;
        this.isVisited = false;
        this.state = GraphNodeState.WHITE;
        this.adjacencyList = new LinkedList<>();
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void markVisited() {
        this.isVisited = true;
    }
}
