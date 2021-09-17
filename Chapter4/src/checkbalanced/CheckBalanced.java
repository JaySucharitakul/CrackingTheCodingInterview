package checkbalanced;

import classpackage.BinaryTree;
import classpackage.Node;

public class CheckBalanced<T extends Comparable<T>> {

    public boolean isBalanced(BinaryTree<T> tree) {
        return checkHeightRec(tree.getRoot()) != Integer.MIN_VALUE;
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
}
