package minimaltree;

import java.util.ArrayList;

public class Node {
    private final int value;
    private Node right;
    private Node left;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getRight() { return right; }

    public void setRight(Node right) { this.right = right; }

    public Node getLeft() { return left; }

    public void setLeft(Node left) { this.left = left; }
}
