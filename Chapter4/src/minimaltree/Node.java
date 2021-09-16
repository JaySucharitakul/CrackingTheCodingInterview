package minimaltree;

import java.util.ArrayList;

public class Node<T> {
    private final T value;
    private Node<T> right;
    private Node<T> left;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getRight() { return right; }

    public void setRight(Node<T> right) { this.right = right; }

    public Node<T> getLeft() { return left; }

    public void setLeft(Node<T> left) { this.left = left; }
}
