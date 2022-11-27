package com.app.leetcode;

import com.app.Solution;
import com.app.reference.graph.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class TicketNode {
    String value;
    boolean isVisited;
    LinkedList<TicketNode> adjacentList;

    public TicketNode(String value) {
        this.value = value;
        this.isVisited = false;
        this.adjacentList = new LinkedList<>();
    }
}

public class ReconstructItinerary implements Solution {
    private List<TicketNode> graphList;
    private HashMap<String, TicketNode> valueToGraphNodeMap;

    public ReconstructItinerary(String[] nodeValues) {
        this.graphList = new ArrayList<>();
        valueToGraphNodeMap = new HashMap<>();
        for (int i=0; i<nodeValues.length; i++) {
            TicketNode node = new TicketNode(nodeValues[i]);
            graphList.add(node);
            valueToGraphNodeMap.put(nodeValues[i], node);
        }
    }

    public void addLink(int fromValue1, int toValue2) throws Exception {
        if (valueToGraphNodeMap.get(fromValue1) == null || valueToGraphNodeMap.get(toValue2) == null) {
            throw new Exception("Invalid input!");
        }
        TicketNode fromNode = valueToGraphNodeMap.get(fromValue1);
        TicketNode toNode = valueToGraphNodeMap.get(toValue2);

        if (!fromNode.adjacentList.contains(toNode))
            fromNode.adjacentList.add(toNode);
    }

    




    @Override
    public void execute() {

    }
}
