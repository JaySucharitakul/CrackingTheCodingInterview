package validatebst;

import classpackage.BinaryTree;
import classpackage.Node;

import java.util.LinkedList;

public class ValidateBst<T extends Comparable<T>> {

    BinaryTree<T> tree;
    public ValidateBst(BinaryTree<T> tree) {
        this.tree = tree;
    }

    public boolean validateTree() {
        Node<T> root = tree.getRoot();
        return isBst(root);
    }

    private void storeInOrder(Node<T> root, LinkedList<T> array) {
        if (root == null)
            return;
        storeInOrder(root.getLeft(), array);
        array.add(root.getValue());
        storeInOrder(root.getRight(), array);
    }

    private boolean isBst(Node<T> root) {
        LinkedList<T> array = new LinkedList<>();
        storeInOrder(root, array);
        for (int i = 1; i < array.size() - 1; i++) {
            if (array.get(i).compareTo(array.get(i - 1)) < 0)
                return false;
        }
        return true;
    }
}
