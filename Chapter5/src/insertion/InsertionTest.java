package insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {

    public static String toBinaryString(int num) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int lsb = num & 1;
            str.insert(0, lsb);
            num = num >> 1;
        }
        return str.toString();
    }

    @Test
    void updateBits() {
        int a = 1024;
        int b = 19;
        int c = Insertion.updateBits(a, b, 2, 6);
        assertEquals(toBinaryString(1100), toBinaryString(c));
    }
}