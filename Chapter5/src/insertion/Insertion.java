package insertion;

public class Insertion {
    public static int updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (1 << i) - 1;
        int mask = left | right;
        n = n & mask;
        m = m << i;
        return n | m;
    }
}
