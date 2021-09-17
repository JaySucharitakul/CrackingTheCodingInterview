package minimaltree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalTreeTest {

    @Test
    void MinimalTree() {
        Integer[] array = new Integer[] { 5, 2, 9, 1, 6, 4, 3, 10 };

        MinimalTree<Integer> tree = new MinimalTree<>(array);

        tree.printTree();
    }
}