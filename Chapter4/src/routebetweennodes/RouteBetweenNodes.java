package routebetweennodes;

import java.util.ArrayList;

public class RouteBetweenNodes {

    public DirectedGraph<String> generateGraph() {
        ArrayList<Node<String>> temp = new ArrayList<>();

        temp.add(new Node<>("a"));
        temp.add(new Node<>("b"));
        temp.add(new Node<>("c"));
        temp.add(new Node<>("d"));
        temp.add(new Node<>("e"));
        temp.add(new Node<>("f"));

        temp.get(0).addChild(temp.get(1));
        temp.get(0).addChild(temp.get(2));
        temp.get(0).addChild(temp.get(3));
        temp.get(3).addChild(temp.get(4));
        temp.get(4).addChild(temp.get(5));

        DirectedGraph<String> newGraph = new DirectedGraph<>();
        for (Node<String> stringNode : temp) {
            newGraph.addNode(stringNode);
        }
        return newGraph;
    }

    public boolean checkRouteConnected(DirectedGraph<String> graph, Node<String> node1, Node<String> node2) {
        if (!graph.getNodes().contains(node1) && !graph.getNodes().contains(node2))
            return false;
        return node1.getChildren().contains(node2) || node2.getChildren().contains(node1);
    }
}
