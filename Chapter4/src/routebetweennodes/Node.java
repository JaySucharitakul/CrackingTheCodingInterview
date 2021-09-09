package routebetweennodes;

import java.util.ArrayList;

public class Node<T> {
    private final T name;
    private final ArrayList<Node<T>> children;

    public Node(T name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public T getName() {
        return name;
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void addChild(Node<T> node) {
        children.add(node);
    }
}
