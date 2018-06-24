package net.braingang.java_lab.array_basic1;

import java.util.Arrays;

public class Main {

    public int[][] solver(int row, int column) {
        int[][] result = new int[row][column];

        int colNdx = 0;
        int rowNdx = 0;
        boolean direction = true;
        for (int ii = 0; ii < (row * column); ii++) {
            result[rowNdx][colNdx] = ii;

            if (direction) {
                ++rowNdx;
                if (rowNdx >= row) {
                    direction = !direction;
                    rowNdx = row-1;
                    ++colNdx;
                }
            } else {
                --rowNdx;
                if (rowNdx < 0) {
                    direction = !direction;
                    rowNdx = 0;
                    ++colNdx;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        int limit = 3;

        char board1[][] = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        for (int row = 0; row < limit; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(board1[row]));
        }

        for (int row = 0; row < limit; row++) {
            for (int column = 0; column < limit; column++) {
                System.out.print(board1[row][column] + " ");
            }

            System.out.println();
        }

        Main main = new Main();
        int[][] google = main.solver(4, 5);

        for (int row2 = 0; row2 < 4; row2++) {
            System.out.println(Arrays.toString(google[row2]));
        }

        System.out.println("end");
    }

    /*
    0 8 9  16 17
    1 7 10 15 18
    3 6 11 14 19
    4 5 12 13 20
   */
}
