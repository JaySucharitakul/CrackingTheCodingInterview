package minimaltree;

import java.util.Optional;

public class MinimalTree<T extends Comparable<T>> {
    private Node<T> root;

    public MinimalTree() {
        root = null;
    }

    public MinimalTree(T value) {
        root = new Node<>(value);
    }

    public void addNode(T value) {
        root = addNodeRec(root, value).orElse(null);
    }

    public Optional<Node<T>> addNodeRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return Optional.of(root);
        }

        if (value.compareTo(root.getValue()) < 0)
            root.setLeft(addNodeRec(root.getLeft(), value).orElse(null));
        else if (value.compareTo(root.getValue()) > 0)
            root.setRight(addNodeRec(root.getRight(), value).orElse(null));

        return Optional.of(root);
    }
}
