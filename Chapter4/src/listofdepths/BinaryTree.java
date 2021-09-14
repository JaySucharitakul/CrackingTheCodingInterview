package listofdepths;

import java.util.Optional;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public void addNode(int value) {
        root = addNodeRec(root, value).orElse(null);
    }

    public Optional<Node> addNodeRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return Optional.of(root);
        }

        if (value < root.getValue())
            root.setLeft(addNodeRec(root.getLeft(), value).orElse(null));
        else if (value > root.getValue())
            root.setRight(addNodeRec(root.getRight(), value).orElse(null));

        return Optional.of(root);
    }
}
