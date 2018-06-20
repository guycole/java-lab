package net.braingang.java_lab.array_rotate1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void rotate(int[][] matrix) {
        int sideLimit = matrix.length;

        Queue<Integer> queue = new LinkedList<>();

        for (int rowNdx = 0; rowNdx < sideLimit; rowNdx++) {
            for (int colNdx = 0; colNdx < sideLimit; colNdx++) {
                queue.add(matrix[rowNdx][colNdx]);
            }
        }

        for (int colNdx = sideLimit -1; colNdx >= 0; colNdx--) {
            for (int rowNdx = 0; rowNdx < sideLimit; rowNdx++) {
                matrix[rowNdx][colNdx] = queue.poll();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int image1[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int row = 0; row < 3; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(image1[row]));
        }

        main.rotate(image1);

        for (int row = 0; row < 3; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(image1[row]));
        }

        System.out.println("end");
    }
}
