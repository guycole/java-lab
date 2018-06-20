package net.braingang.java_lab.matrix_ops1;

import java.util.Arrays;

public class Main {

    public void transpose(int[][] matrix) {
        int sideLimit = matrix.length;

        for (int ii = 0; ii < sideLimit; ii++) {
            for (int jj = ii; jj < sideLimit; jj++) {
                int temp = matrix[jj][ii];
                matrix[jj][ii] = matrix[ii][jj];
                matrix[ii][jj] = temp;
            }
        }
    }

    public void reverse(int[][] matrix) {
        int sideLimit = matrix.length;

        for (int ii = 0; ii < sideLimit; ii++) {
            for (int jj = 0; jj < sideLimit/2; jj++) {
                int temp = matrix[ii][jj];
                matrix[ii][jj] = matrix[ii][sideLimit-1-jj];
                matrix[ii][sideLimit-1-jj] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int matrix1[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int row = 0; row < 3; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(matrix1[row]));
        }

        main.transpose(matrix1);

        for (int row = 0; row < 3; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(matrix1[row]));
        }

        main.reverse(matrix1);

        for (int row = 0; row < 3; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(matrix1[row]));
        }

        System.out.println("end");
    }
}
