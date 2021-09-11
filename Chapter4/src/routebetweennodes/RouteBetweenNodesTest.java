package routebetweennodes;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenNodesTest {

    @org.junit.jupiter.api.Test
    void checkRouteConnected() {
        RouteBetweenNodes test = new RouteBetweenNodes();
        DirectedGraph<String> graph;
        graph = test.generateGraph();
        ArrayList<Node<String>> nodeList = graph.getNodes();
        Node<String> testFalseNode1 = nodeList.get(3);
        Node<String> testFalseNode2 = nodeList.get(5);
        assertFalse(test.checkRouteConnected(graph, testFalseNode1, testFalseNode2));
        Node<String> testTrueNode1 = nodeList.get(1);
        Node<String> testTrueNode2 = nodeList.get(0);
        assertTrue(test.checkRouteConnected(graph, testTrueNode1, testTrueNode2));
    }
}