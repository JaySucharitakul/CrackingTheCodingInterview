import java.util.Scanner;

public class ZeroMatrix {
    public static void main(String[] args) {
        int matrix[][]={
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

        matrix = checkZero(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] checkZero(int matrix[][])
    {
        int check[][] = matrix;
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                if (check[i][j] == 0)
                {
                    for (int k = 0; k < check.length; k++)
                    {
                        check[k][j] = 0;
                    }
                    for (int l = 0; l < check[i].length; l++)
                    {
                        check[i][l] = 0;
                    }
                    return check;
                }
            }
        }
        return check;
    }


}
