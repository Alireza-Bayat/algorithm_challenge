package leet.graph;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import utils.GraphNode;

public class CloneGraphTest {

    private CloneGraph cloneGraph;

    @Before
    public void prepare() {
        cloneGraph = new CloneGraph();
    }

    @Test
    public void cloneGraph() {
        GraphNode a = new GraphNode(10);
        GraphNode b = new GraphNode(11);
        GraphNode c = new GraphNode(12);
        a.neighbors = List.of(b);
        b.neighbors = List.of(c);

        cloneGraph.cloneGraph(a);

        System.out.println("DONE");

    }
}