package checkbalanced;

import java.util.LinkedList;

public class BinaryTree {
    private Node root;
    private LinkedList<LinkedList<Node>> depthList;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public void addNode(int value) {
        root = addNodeRec(root, 0, value);
    }

    public Node addNodeRec(Node root, int depth, int value) {
        if (root == null) {
            root = new Node(value);
            root.setDepth(depth);
            addToDepthList(root);
            return root;
        }

        if (value < root.getValue())
            root.setLeft(addNodeRec(root.getLeft(), ++depth, value));
        else if (value > root.getValue())
            root.setRight(addNodeRec(root.getRight(), ++depth, value));
        return root;
    }

    public void addToDepthList(Node node) {
        int currentDepth = node.getDepth();
        if (currentDepth < 0)
            throw new IndexOutOfBoundsException();

        if (depthList.get(currentDepth) == null) {
            LinkedList<Node> depthRow = new LinkedList<>();
            depthRow.add(node);
            depthList.add(depthRow);
        } else {
            depthList.get(currentDepth).add(node);
        }
    }
}
