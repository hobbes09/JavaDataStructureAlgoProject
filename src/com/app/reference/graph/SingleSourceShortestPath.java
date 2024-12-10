package com.app.reference.graph;

import com.app.Solution;

import java.util.*;


/*
Dijkstra Algorithm
https://www.youtube.com/watch?v=XB4MIexjvY0
 */
public class SingleSourceShortestPath implements Solution {

    class Node {
        String name;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class NodeDistance{
        Node node;
        int distance;

        public NodeDistance(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    class EdgeNode {
        Node node;
        int edgeWeight;

        public EdgeNode(Node node, int edgeWeight) {
            this.node = node;
            this.edgeWeight = edgeWeight;
        }

        @Override
        public String toString() {
            return "EdgeNodes{" +
                    "node=" + node +
                    ", edgeWeight=" + edgeWeight +
                    '}';
        }
    }

    HashMap<Node, ArrayList<EdgeNode>> allAdjNodes;
    HashMap<String, Node> nodesCollection;

    HashMap<Node, Integer> minDistances;

    PriorityQueue<Node> minHeapNodeDistances;

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodesCollection.getOrDefault(from, new Node(from));
        Node toNode = nodesCollection.getOrDefault(to, new Node(to));

        nodesCollection.putIfAbsent(from, fromNode);
        nodesCollection.putIfAbsent(to, toNode);

        ArrayList<EdgeNode> adjNodes = allAdjNodes.getOrDefault(fromNode, new ArrayList<>());
        adjNodes.add(new EdgeNode(toNode, weight));
        allAdjNodes.put(fromNode, adjNodes);
    }

    public void initialiseShortestDistances(Node startNode) {
        minDistances = new HashMap<>();
        minHeapNodeDistances = new PriorityQueue<>((n1, n2)->{
            int distN1 = minDistances.get(n1);
            int distN2 = minDistances.get(n2);
            return distN1-distN2;
        });

        for (Map.Entry<String, Node> entry: nodesCollection.entrySet()) {
            int distance = (entry.getValue() == startNode) ? 0 : Integer.MAX_VALUE;
            minDistances.put(entry.getValue(), distance);
            minHeapNodeDistances.add(entry.getValue());
        }
    }

    /*
    Dijkstra Algorithm code
     */
    public void calculateShortestDistancesAndUpdate() {

        Node minDistanceNode = minHeapNodeDistances.poll();
        while(minDistanceNode!=null) {
            relaxEdgesOfNode(minDistanceNode);
            minDistanceNode = minHeapNodeDistances.poll();
        }
    }

    private void relaxEdgesOfNode(Node minDistanceNode) {

        ArrayList<EdgeNode> adjNodes = allAdjNodes.get(minDistanceNode);
        if (adjNodes == null)
            return;
        for(EdgeNode edgeNode: adjNodes) {
            Node node = edgeNode.node;
            int distanceFromSource = minDistances.get(minDistanceNode) + edgeNode.edgeWeight;
            if (distanceFromSource < minDistances.get(node)) {
                minDistances.put(node, distanceFromSource);
            }
            minHeapNodeDistances.remove(node);
            minHeapNodeDistances.add(node);
        }
    }

    @Override
    public void execute() {

        nodesCollection = new HashMap<>();
        allAdjNodes = new HashMap<>();

        // Create graph
        // Add Edges using addEdge. This will create nodes too and the whole graph
        addEdge("1", "2", 2);
        addEdge("1", "3", 4);
        addEdge("2", "4", 7);
        addEdge("2", "3", 1);
        addEdge("3", "5", 3);
        addEdge("5", "4", 2);
        addEdge("5", "6", 5);
        addEdge("4", "6", 1);

        // Call initialiseShortestDistances
        Node startNode = nodesCollection.get("1");
        initialiseShortestDistances(startNode);

        // Start Dijkstra Algorithm
        calculateShortestDistancesAndUpdate();

        printMinDistances();

    }

    private void printMinDistances() {
        for (Map.Entry<Node, Integer> entry : minDistances.entrySet()) {
            System.out.println(entry.getKey().name + " --- " + entry.getValue());
        }
    }
}
