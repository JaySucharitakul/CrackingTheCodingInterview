public class RotateMatrix {

    public static void main(String[] args)
    {
        int[][] matrix ={
                {1*1,1*2,2*3,3*2},
                {0*1,1*1,2*1,3*1},
                {3*2,1*2,2*2,3*2},
                {2*3,1*3,2*3,3*3}
        };

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        rotateMatrix(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static boolean rotateMatrix(int[][] matrix)
    {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int length = matrix.length;

        for (int x = 0; x < length / 2; x++)
        {
            for (int y = x; y < length - x - 1; y++)
            {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][length - 1 - x];
                matrix[y][length - 1 - x] = matrix[length - 1 - x][length - 1 - y];
                matrix[length - 1 - x][length - 1 - y] = matrix[length - 1 - y][x];
                matrix[length - 1 - y][x] = temp;
            }
        }
        return true;
    }
}
