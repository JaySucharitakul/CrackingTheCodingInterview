package listofdepths;

import java.util.LinkedList;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private LinkedList<LinkedList<Node<T>>> depthList;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node<>(value);
    }

    public void addNode(int value) {
        root = addNodeRec(root, 0, value);
    }

    public Node<T> addNodeRec(Node<T> root, int depth, int value) {
        if (root == null) {
            root = new Node<>(value);
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

    public void addToDepthList(Node<T> node) {
        int currentDepth = node.getDepth();
        if (currentDepth < 0)
            throw new IndexOutOfBoundsException();

        if (depthList.get(currentDepth) == null) {
            LinkedList<Node<T>> depthRow = new LinkedList<>();
            depthRow.add(node);
            depthList.add(depthRow);
        } else {
            depthList.get(currentDepth).add(node);
        }
    }

    public void printDepthList() {
        for (int i = 0; i < depthList.size(); i++) {
            System.out.println("Depth: " + i);
            LinkedList<Node<T>> currentDepth = depthList.get(i);
            for (Node<T> node : currentDepth) {
                System.out.print(node + " ");
            }
        }
    }
}
