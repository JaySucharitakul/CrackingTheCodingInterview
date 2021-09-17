package validatebst;

import classpackage.BinaryTree;
import classpackage.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidateBstTest {

    @Test
    void validateTreeTrue() {
        BinaryTree<Integer> testTree = new BinaryTree<>();
        testTree.addNode(4);
        testTree.addNode(2);
        testTree.addNode(5);
        testTree.addNode(1);
        testTree.addNode(3);

        testTree.printTree();

        ValidateBst<Integer> testValid = new ValidateBst<>(testTree);
        assertTrue(testValid.validateTree());
    }

    @Test
    void validateTreeFalse() {
        Node<Integer> incorrectTest = new Node<>(3);
        incorrectTest.setLeft(new Node<>(2));
        incorrectTest.setRight(new Node<>(5));
        incorrectTest.getLeft().setLeft(new Node<>(1));
        incorrectTest.getLeft().setRight(new Node<>(4));

        BinaryTree<Integer> testTree = new BinaryTree<>(incorrectTest);

        testTree.printTree();

        ValidateBst<Integer> testValid = new ValidateBst<>(testTree);
        assertFalse(testValid.validateTree());
    }
}