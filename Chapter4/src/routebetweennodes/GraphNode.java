package routebetweennodes;

import java.util.ArrayList;

public class GraphNode<T> {
    private final int MAX_CHILDREN = 6;
    private final T name;
    private final ArrayList<GraphNode<T>> children;

    public GraphNode(T name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public T getName() {
        return name;
    }

    public ArrayList<GraphNode<T>> getChildren() {
        return children;
    }

    public void addChild(GraphNode<T> node) {
        if (MAX_CHILDREN != children.size())
            children.add(node);
        else
            System.out.println("Max number of children reached");
    }
}
