package routebetweennodes;

import java.util.ArrayList;
import java.util.Optional;

public class DirectedGraph<T> {
    private final ArrayList<Node<T>> nodes;

    public DirectedGraph() {
        nodes = new ArrayList<>();
    }

    public DirectedGraph(ArrayList<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public boolean contains(Node<T> node) {
        return nodes.contains(node);
    }

    public boolean contains(T name) {
        for (int i = 0; i < getNodes().size(); i++)
            if (nodes.get(i).getName() == name)
                return true;
        return false;
    }

    public Node<T> getNode(T name) {
        for (int i = 0; i < getNodes().size(); i++)
            if (nodes.get(i).getName() == name)
                return nodes.get(i);
        return null;
    }

    public Node<T> getNode(int index) {
        return nodes.get(index);
    }

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }
}
