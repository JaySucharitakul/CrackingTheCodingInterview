package validatebst;

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

    public boolean isBalanced() {
        return checkHeightRec(root) != Integer.MIN_VALUE;
    }

    private int checkHeightRec(Node<T> root) {
        if (root == null)
            return -1;

        int leftHeight = checkHeightRec(root.getLeft());
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rightHeight = checkHeightRec(root.getRight());
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int getHeight(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    public Node<T> getRoot() {
        return root;
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
}
