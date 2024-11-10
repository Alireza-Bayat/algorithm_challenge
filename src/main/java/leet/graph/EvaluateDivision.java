package leet.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 * <p>
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            results[i] = dfs(C, D, new HashSet<>(), graph);
        }

        return results;
    }

    // DFS helper function to find the path and calculate the result
    private double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        // If start or end is not in the graph, return -1.0
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        // If start equals end, the division result is 1.0
        if (start.equals(end)) {
            return 1.0;
        }

        visited.add(start);
        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextNode = neighbor.getKey();
            if (!visited.contains(nextNode)) {
                double result = dfs(nextNode, end, visited, graph);
                if (result != -1.0) {
                    return neighbor.getValue() * result;
                }
            }
        }

        return -1.0;
    }
}
