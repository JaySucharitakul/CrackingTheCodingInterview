package routebetweennodes;

import java.util.ArrayList;

public class RouteBetweenNodes {

    public DirectedGraph<String> generateGraph() {
        ArrayList<GraphNode<String>> temp = new ArrayList<>();

        temp.add(new GraphNode<>("a"));
        temp.add(new GraphNode<>("b"));
        temp.add(new GraphNode<>("c"));
        temp.add(new GraphNode<>("d"));
        temp.add(new GraphNode<>("e"));
        temp.add(new GraphNode<>("f"));

        temp.get(0).addChild(temp.get(1));
        temp.get(0).addChild(temp.get(2));
        temp.get(0).addChild(temp.get(3));
        temp.get(3).addChild(temp.get(4));
        temp.get(4).addChild(temp.get(5));

        DirectedGraph<String> newGraph = new DirectedGraph<>();
        for (GraphNode<String> stringNode : temp) {
            newGraph.addNode(stringNode);
        }
        return newGraph;
    }

    public boolean checkRouteConnected(DirectedGraph<String> graph, GraphNode<String> node1, GraphNode<String> node2) {
        if (!graph.getNodes().contains(node1) && !graph.getNodes().contains(node2))
            return false;
        return node1.getChildren().contains(node2) || node2.getChildren().contains(node1);
    }
}
