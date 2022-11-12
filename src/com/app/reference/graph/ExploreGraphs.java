package com.app.reference.graph;

import com.app.Solution;

public class ExploreGraphs implements Solution {
    @Override
    public void execute() {
        SimpleGraph graph = new SimpleGraph(4);
        try {
            graph.addEdge(0,1);
            graph.addEdge(0,2);
            graph.addEdge(1,2);
            graph.addEdge(2,0);
            graph.addEdge(2,3);
            graph.addEdge(3,3);

            System.out.println("BFS : ");
            graph.bfs(2);
            System.out.println("\nDFS : ");
            graph.dfs(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TopologicalSort topologicalSort = new TopologicalSort(6);
        try {
            topologicalSort.addEdge(5,2);
            topologicalSort.addEdge(5,0);
            topologicalSort.addEdge(4,0);
            topologicalSort.addEdge(4,1);
            topologicalSort.addEdge(2,3);
            topologicalSort.addEdge(3,1);

            System.out.println("\nTopologicalSort : ");
            topologicalSort.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TopologicalSortWithCycleDetection topologicalSort1 = new TopologicalSortWithCycleDetection(6);
        try {
            topologicalSort1.addEdge(5,2);
            topologicalSort1.addEdge(5,0);
            topologicalSort1.addEdge(4,0);
            topologicalSort1.addEdge(4,1);
            topologicalSort1.addEdge(2,3);
            topologicalSort1.addEdge(3,1);

            System.out.println("\nTopologicalSortWithCycleDetection : ");
            topologicalSort1.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
