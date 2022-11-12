package com.app.reference;

import com.app.reference.GraphNode;

import java.util.*;

public class GraphBreadthFirstSearch {

    private List<GraphNode> graphList;
    private int totalNodes;

    public GraphBreadthFirstSearch(int totalNodes) {
        this.totalNodes = totalNodes;
        this.graphList = new ArrayList<>();
        for (int i=0; i<totalNodes; i++) {
            graphList.add(new GraphNode(i));
        }
    }

    public List<GraphNode> addLink(int v1, int v2) throws Exception {
        if (graphList.get(v1) == null || graphList.get(v2) == null) {
            throw new Exception("Invalid input!");
        }
        graphList.get(v1).adjacencyList.add(graphList.get(v2));
        graphList.get(v2).adjacencyList.add(graphList.get(v1));
        return graphList;
    }

    public void breadFirstSearch(int s) throws Exception {
        if (graphList.get(s) == null) {
            throw new Exception("Invalid input!");
        }

        Queue<GraphNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if(!node.isVisited) {
                LinkedList<GraphNode> linkedNodes = node.adjacencyList;
                queue.addAll(linkedNodes);
                node.markVisited();
                System.out.print(node.value + " -> ");
            }
        }
    }
}
