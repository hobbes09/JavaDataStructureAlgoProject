package com.app.reference.graph;

import com.app.Solution;

import java.util.*;

public class GraphBreadthFirstSearch implements Solution {

    private List<GraphNode> graphList;
    private HashMap<Integer, GraphNode> valueToGraphNodeMap;

    public GraphBreadthFirstSearch(int[] nodeValues) {
        this.graphList = new ArrayList<>();
        valueToGraphNodeMap = new HashMap<>();
        for (int i=0; i<nodeValues.length; i++) {
            GraphNode node = new GraphNode(nodeValues[i]);
            graphList.add(node);
            valueToGraphNodeMap.put(nodeValues[i], node);
        }
    }

    public List<GraphNode> addLink(int fromValue1, int toValue2) throws Exception {
        if (valueToGraphNodeMap.get(fromValue1) == null || valueToGraphNodeMap.get(toValue2) == null) {
            throw new Exception("Invalid input!");
        }
        GraphNode fromNode = valueToGraphNodeMap.get(fromValue1);
        GraphNode toNode = valueToGraphNodeMap.get(toValue2);

        fromNode.adjacencyList.add(toNode);
        return graphList;
    }

    public void breadFirstSearch(int source) throws Exception {
        GraphNode sourceNode = valueToGraphNodeMap.get(source);
        if (sourceNode == null) {
            throw new Exception("Invalid input!");
        }

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(sourceNode);
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

    @Override
    public void execute() {

    }
}
