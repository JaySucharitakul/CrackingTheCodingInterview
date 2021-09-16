package listofdepths;

public class Node<T> {
    private final int value;
    private Node<T> right;
    private Node<T> left;
    private int depth;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getDepth() { return depth; }

    public void setDepth(int depth) { this.depth = depth; }

    public Node<T> getRight() { return right; }

    public void setRight(Node<T> right) { this.right = right; }

    public Node<T> getLeft() { return left; }

    public void setLeft(Node<T> left) { this.left = left; }
}
