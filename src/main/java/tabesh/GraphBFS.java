package tabesh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBFS {

    // Graph represented as an adjacency list
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the graph
    public GraphBFS() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    // BFS function
    public void BFS(int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Start with the initial node
        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();  // Dequeue a node
            System.out.print(node + " ");  // Print the current node

            // Visit all the adjacent nodes
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);  // Enqueue the adjacent nodes
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("BFS starting from node 2:");
        graph.BFS(2);
    }
}
