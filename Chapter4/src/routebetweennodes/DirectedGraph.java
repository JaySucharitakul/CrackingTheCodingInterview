package routebetweennodes;

import java.util.ArrayList;
import java.util.Optional;

public class DirectedGraph<T> {
    private final int GRAPH_LIMIT = 6;
    private final ArrayList<Node<T>> nodes;

    public DirectedGraph() {
        nodes = new ArrayList<>();
    }

    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }

    public void addNode(Node<T> node) {
        if (GRAPH_LIMIT != nodes.size())
            nodes.add(node);
        else
            System.out.println("Graph limit has been reached");
    }
}
