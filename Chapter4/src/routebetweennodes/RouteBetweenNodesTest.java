package routebetweennodes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenNodesTest {

    @Test
    void checkRouteConnected() {
        RouteBetweenNodes test = new RouteBetweenNodes();
        DirectedGraph<String> graph;
        graph = test.generateGraph();
        ArrayList<GraphNode<String>> nodeList = graph.getNodes();
        GraphNode<String> testFalseNode1 = nodeList.get(3);
        GraphNode<String> testFalseNode2 = nodeList.get(5);
        assertFalse(test.checkRouteConnected(graph, testFalseNode1, testFalseNode2));
        GraphNode<String> testTrueNode1 = nodeList.get(1);
        GraphNode<String> testTrueNode2 = nodeList.get(0);
        assertTrue(test.checkRouteConnected(graph, testTrueNode1, testTrueNode2));
    }
}