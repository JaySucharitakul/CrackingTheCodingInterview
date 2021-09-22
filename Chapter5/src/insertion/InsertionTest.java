package insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {

    @Test
    void updateBits() {
        int n = 100000000;
        int m = 10011;

        int result = Insertion.updateBits(n, m, 2, 6);

        // test doesn't result correctly
        assertEquals(101001100, result);
    }
}