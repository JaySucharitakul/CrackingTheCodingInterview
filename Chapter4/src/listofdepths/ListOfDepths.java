package listofdepths;

import classpackage.BinaryTree;
import classpackage.Node;

import java.util.LinkedList;
import java.util.Optional;

public class ListOfDepths<T extends Comparable<T>> extends BinaryTree<T> {
    private LinkedList<LinkedList<Node<T>>> depthList;

    @Override
    public Optional<Node<T>> addNodeRec(Node<T> root, int depth, T value) {
        if (root == null) {
            root = new Node<>(value);
            root.setDepth(depth);
            addToDepthList(root);
            return Optional.of(root);
        }

        if (value.compareTo(root.getValue()) < 0)
            root.setLeft(addNodeRec(root.getLeft(), ++depth, value).orElse(null));
        else if (value.compareTo(root.getValue()) > 0)
            root.setRight(addNodeRec(root.getRight(), ++depth, value).orElse(null));
        return Optional.of(root);
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

    public void printDepthList() {
        for (int i = 0; i < depthList.size(); i++) {
            System.out.println("Depth: " + i);
            LinkedList<Node<T>> currentDepth = depthList.get(i);
            for (Node<T> node : currentDepth) {
                System.out.print(node + " ");
            }
        }
    }
}
