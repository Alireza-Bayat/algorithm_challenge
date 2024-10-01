package tabesh;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphDFS {


    // Graph represented as an adjacency list
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the graph
    public GraphDFS() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
    }

    // DFS recursive function
    private void dfsRecursive(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");  // Print the current node

        // Visit all the adjacent nodes
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // Wrapper function for DFS
    public void DFS(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startNode, visited);
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("DFS starting from node 2:");
        graph.DFS(2);
    }
}

