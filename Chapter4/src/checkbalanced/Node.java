package checkbalanced;

public class Node {
    private final int value;
    private Node right;
    private Node left;
    private int depth;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getDepth() { return depth; }

    public void setDepth(int depth) { this.depth = depth; }

    public Node getRight() { return right; }

    public void setRight(Node right) { this.right = right; }

    public Node getLeft() { return left; }

    public void setLeft(Node left) { this.left = left; }
}
