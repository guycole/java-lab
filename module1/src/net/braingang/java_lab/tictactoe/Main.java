package net.braingang.java_lab.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

import static net.braingang.java_lab.tictactoe.Main.GameStatusType.*;

public class Main {
    public static char OO = 'O';
    public static char XX = 'X';
    public static char SPACE = ' ';
    public enum GameStatusType { IN_PROCESS, OO_WIN, XX_WIN, GAME_DRAW };

    public void resetMatrix(char[][] matrix) {
        for (int ii = 0; ii < matrix.length; ii++) {
            for (int jj = 0; jj < matrix.length; jj++) {
                matrix[ii][jj] = SPACE;
            }
        }
    }

    public void dumper(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println("row:" + row + ":" + Arrays.toString(matrix[row]));
        }
    }

    public GameStatusType statusTest(int matrixLength, int ooPopulation, int xxPopulation) {
        if (ooPopulation == matrixLength) {
            return OO_WIN;
        } else if (xxPopulation == matrixLength) {
            return XX_WIN;
        } else if (ooPopulation + xxPopulation == matrixLength) {
            return GAME_DRAW;
        }

        return IN_PROCESS;
    }

    public GameStatusType testDiagonal1(char[][] matrix) {
        int ooPopulation = 0;
        int xxPopulation = 0;

        for (int row = 0; row < matrix.length; row++) {
            int column = row;

            if (matrix[row][column] == OO) {
                ++ooPopulation;
            } else if (matrix[row][column] == XX) {
                ++xxPopulation;
            }
        }

        return statusTest(matrix.length, ooPopulation, xxPopulation);
    }

    public GameStatusType testDiagonal2(char[][] matrix) {
        int ooPopulation = 0;
        int xxPopulation = 0;

        int column = matrix.length-1;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][column] == OO) {
                ++ooPopulation;
            } else if (matrix[row][column] == XX) {
                ++xxPopulation;
            }

            --column;
        }

        return statusTest(matrix.length, ooPopulation, xxPopulation);
    }

    public GameStatusType testColumn(char[][] matrix, int column) {
        int ooPopulation = 0;
        int xxPopulation = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][column] == OO) {
                ++ooPopulation;
            } else if (matrix[row][column] == XX) {
                ++xxPopulation;
            }
        }

        return statusTest(matrix.length, ooPopulation, xxPopulation);
    }

    public GameStatusType testRow(char[][] matrix, int row) {
        int ooPopulation = 0;
        int xxPopulation = 0;

        for (int column = 0; column < matrix.length; column++) {
            if (matrix[row][column] == OO) {
                ++ooPopulation;
            } else if (matrix[row][column] == XX) {
                ++xxPopulation;
            }
        }

        return statusTest(matrix.length, ooPopulation, xxPopulation);
    }

    public GameStatusType testStatus(char[][] matrix) {
        int drawCounter = 0;

        dumper(matrix);

        for (int row = 0; row < matrix.length; row++) {
            switch (testRow(matrix, row)) {
                case IN_PROCESS:
                    break;
                case OO_WIN:
                    return OO_WIN;
                case XX_WIN:
                    return XX_WIN;
                case GAME_DRAW:
                    ++drawCounter;
            }
        }

        for (int column = 0; column < matrix.length; column++) {
            switch (testColumn(matrix, column)) {
                case IN_PROCESS:
                    break;
                case OO_WIN:
                    return OO_WIN;
                case XX_WIN:
                    return XX_WIN;
                case GAME_DRAW:
                    ++drawCounter;
            }
        }

        switch (testDiagonal1(matrix)) {
            case IN_PROCESS:
                break;
            case OO_WIN:
                return OO_WIN;
            case XX_WIN:
                return XX_WIN;
            case GAME_DRAW:
                ++drawCounter;
        }

        switch (testDiagonal2(matrix)) {
            case IN_PROCESS:
                break;
            case OO_WIN:
                return OO_WIN;
            case XX_WIN:
                return XX_WIN;
            case GAME_DRAW:
                ++drawCounter;
        }

        System.out.println("drawCount:" + drawCounter);
        if (drawCounter >= matrix.length*2-1) {
            return GAME_DRAW;
        } else {
            return IN_PROCESS;
        }
    }

    public void testGame1(char[][] matrix) {
        resetMatrix(matrix);
        System.out.println(testStatus(matrix));
        matrix[0][0] = OO;
        matrix[1][1] = XX;
        System.out.println(testStatus(matrix));
        matrix[0][1] = OO;
        matrix[2][2] = XX;
        System.out.println(testStatus(matrix));
        matrix[0][2] = OO;
        matrix[2][0] = XX;
        System.out.println(testStatus(matrix));
    }

    public void testGame2(char[][] matrix) {
        resetMatrix(matrix);
        System.out.println(testStatus(matrix));
        matrix[0][0] = OO;
        matrix[1][1] = XX;
        System.out.println(testStatus(matrix));
        matrix[0][1] = OO;
        matrix[0][2] = XX;
        System.out.println(testStatus(matrix));
        matrix[2][0] = OO;
        matrix[1][0] = XX;
        System.out.println(testStatus(matrix));
        matrix[1][2] = OO;
        matrix[2][1] = XX;
        System.out.println(testStatus(matrix));
    }

    public static void main(String[] args) {
        System.out.println("begin");

        char board1[][] = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        Main main = new Main();
        main.dumper(board1);
        main.testGame1(board1);
        main.testGame2(board1);

/*
        Scanner scanner = new Scanner(System.in);
        String test = scanner.next();
        System.out.println(test);
*/

        System.out.println("end");
    }
}
