package classpackage;

import java.util.LinkedList;
import java.util.Optional;

public class BinaryTree<T extends Comparable<T>> {
    protected Node<T> root;
    private LinkedList<LinkedList<Node<T>>> depthList;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T value) {
        root = new Node<>(value);
    }

    public BinaryTree(Node<T> root) { this.root = root; }

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

    public void addNode(T value) {
        root = addNodeRec(root, 0, value).orElse(null);
    }

    protected Optional<Node<T>> addNodeRec(Node<T> root, int depth, T value) {
        if (root == null) {
            root = new Node<>(value);
            root.setDepth(depth);
            return Optional.of(root);
        }

        if (value.compareTo(root.getValue()) < 0)
            root.setLeft(addNodeRec(root.getLeft(), ++depth, value).orElse(null));
        else if (value.compareTo(root.getValue()) > 0)
            root.setRight(addNodeRec(root.getRight(), ++depth, value).orElse(null));
        return Optional.of(root);
    }

    public void printTree() {
        System.out.println(traversePreOrder());
    }

    public String traversePreOrder() {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node<T> node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
}
