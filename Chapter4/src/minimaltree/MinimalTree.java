package minimaltree;

import classpackage.BinaryTree;
import classpackage.Node;

import java.util.Optional;

public class MinimalTree<T extends Comparable<T>> {
    BinaryTree<T> tree;

    public MinimalTree(T[] array) {
        tree = new BinaryTree<>(createMinimalTree(array));
    }

    private Node<T> createMinimalTree(T[] array) {
        return createTreeRec(array, 0, array.length - 1);
    }

    private Node<T> createTreeRec(T[] array, int start, int end) {
        if (end > start)
            return null;

        int mid = (start + end) / 2;
        Node<T> newNode = new Node<>(array[mid]);
        newNode.setLeft(createTreeRec(array, start, mid - 1));
        newNode.setRight(createTreeRec(array, mid + 1, end));

        return newNode;
    }

    public void printTree() {
        tree.printTree();
    }
}
