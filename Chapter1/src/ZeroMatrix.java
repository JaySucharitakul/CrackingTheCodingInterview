import java.util.Arrays;
import java.util.Scanner;

public class ZeroMatrix {
    public static void main(String[] args) {
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

        checkZero(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkZero(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                {
                    for (int k = 0; k < matrix.length; k++)
                    {
                        matrix[k][j] = 0;
                    }
                    Arrays.fill(matrix[i], 0);
                    return true;
                }
            }
        }
        return false;
    }


}
