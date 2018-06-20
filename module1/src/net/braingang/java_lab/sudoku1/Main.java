package net.braingang.java_lab.sudoku1;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public boolean isValidSudoku(char[][] board) {
        //each row contains 1-9 w/no repeats
        //each column contains 1-9 w/no repeats
        //each 3x3 box contains 1-9 w/no repeats

        int limit = 9;

        int[] rowDot = new int[limit];
        Set<Character>[] rowHash = new HashSet[limit];

        int[] columnDot = new int[limit];
        Set<Character>[] columnHash = new HashSet[limit];

        for (int ndx = 0; ndx < limit; ndx++) {
            rowHash[ndx] = new HashSet<>();
            columnHash[ndx] = new HashSet<>();
        }

        for (int row = 0; row < limit; row++) {
            for (int column = 0; column < limit; column++) {
                char temp = board[row][column];
                if (temp == '.') {
                    ++rowDot[row];
                    ++columnDot[column];
                } else {
                    rowHash[row].add(temp);
                    columnHash[column].add(temp);
                }
            }
        }

        for (int row = 0; row < limit; row++) {
            if ((rowDot[row] + rowHash[row].size()) == limit) {
                System.out.println("row ok:" + row);
            } else {
                System.out.println("row fail:" + row);
            }
        }

        for (int column = 0; column < limit; column++) {
            if ((columnDot[column] + columnHash[column].size()) == limit) {
                System.out.println("column ok:" + column);
            } else {
                System.out.println("column fail:" + column);
            }
        }

        for (int row = 0; row < limit; row += 3) {
            for (int column = 0; column < limit; column += 3) {
                System.out.println(row + ":" + column);

                char temp = 'x';
                int dotCounter = 0;
                Set<Character> hashSet = new HashSet<>();

                temp = board[row+0][column+0];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+1][column+0];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+2][column+0];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+0][column+1];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+1][column+1];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+2][column+1];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+0][column+2];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+1][column+2];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                temp = board[row+2][column+2];
                if (temp == '.') {
                    ++dotCounter;
                } else {
                    hashSet.add(temp);
                }

                if ((dotCounter + hashSet.size()) == limit) {
                    System.out.println("square ok");
                } else {
                    System.out.println("square fail");
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        char board1[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(main.isValidSudoku(board1));

        char board2[][] = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(main.isValidSudoku(board2));

        System.out.println("end");
    }
}
