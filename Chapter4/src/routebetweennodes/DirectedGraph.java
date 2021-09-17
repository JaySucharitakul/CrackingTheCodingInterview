package routebetweennodes;

import java.util.ArrayList;

public class DirectedGraph<T> {
    private final int GRAPH_LIMIT = 6;
    private final ArrayList<GraphNode<T>> nodes;

    public DirectedGraph() {
        nodes = new ArrayList<>();
    }

    public ArrayList<GraphNode<T>> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode<T> node) {
        if (GRAPH_LIMIT != nodes.size())
            nodes.add(node);
        else
            System.out.println("Graph limit has been reached");
    }
}
