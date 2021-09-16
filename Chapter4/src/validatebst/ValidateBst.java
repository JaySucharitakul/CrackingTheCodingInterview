package validatebst;

public class ValidateBst<T extends Comparable<T>> {

    public boolean validateTree(BinaryTree<T> tree) {
        Node<T> root = tree.getRoot();
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBstRec(Node<T> node, int min, int max) {
        if (node == null)
            return true;

        if (node.getValue() < min || node.getValue() > max)
            return false;

        return isBstRec(node.getLeft(), min, node.getValue() - 1)
                && isBstRec(node.getRight(), node.getValue() + 1, max);
    }
}
