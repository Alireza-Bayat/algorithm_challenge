package leet.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import utils.GraphNode;

/**
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * <pre>
 * class Node {
 *      public int val;
 *      public List<Node> neighbors;
 * }
 * <p>
 * Test case format:
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node) {
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(node);

        Map<GraphNode, GraphNode> clones = new HashMap<>();
        clones.put(node, new GraphNode(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            GraphNode poll = queue.poll();

            for (GraphNode neighbour : poll.neighbors) {
                if (!clones.containsKey(neighbour)) {
                    clones.put(neighbour, new GraphNode(neighbour.val, new ArrayList<>()));
                    queue.add(neighbour);
                }
                clones.get(poll).neighbors.add(clones.get(neighbour));
            }
        }

        return clones.get(node);
    }
}
