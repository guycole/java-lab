package net.braingang.java_lab.array_basic1;

import java.util.Arrays;

public class Main {


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

        System.out.println("end");
    }
}
