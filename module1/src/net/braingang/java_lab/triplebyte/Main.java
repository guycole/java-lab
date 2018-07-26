package net.braingang.java_lab.triplebyte;


class Board {
    public static char OO = 'O';
    public static char XX = 'X';
    public static char DASH = '-';

    private char board[][] = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
    };

    public void dump() {
        for (int ii = 0; ii < board.length; ii++) {
            for (int jj = 0; jj < board.length; jj++) {
                System.out.print(board[ii][jj]);
                if (jj < board.length-1) {
                    System.out.print('|');
                }
            }

            System.out.println();
        }
    }

    public void setCell(int row, int column, char value) {
        if (boardFull()) {
            throw new IllegalArgumentException("board full");
        }

        board[row][column] = value;
    }

    public boolean boardFull() {
        int counter = 0;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] != DASH) {
                    ++counter;
                }
            }
        }

        if (counter > board.length*2-1) {
            return true; //board full
        }

        return false; //board not full
    }

    public void reset() {
        for (int ii = 0; ii < board.length; ii++) {
            for (int jj = 0; jj < board.length; jj++) {
                board[ii][jj] = DASH;
            }
        }
    }



    public void aiMove() {
        if (board[1][1] == DASH) {
            setCell(1, 1, OO);
            return;
        }

        if (board[0][0] == DASH) {
            setCell(0, 0, OO);
            return;
        }

        if (board[0][2] == DASH) {
            setCell(0, 2, OO);
            return;
        }

        if (board[2][0] == DASH) {
            setCell(2, 0, OO);
            return;
        }


        if (board[2][2] == DASH) {
            setCell(2, 2, OO);
            return;
        }

        if (board[0][0] == OO) {
            if (board[0][1] == DASH) {
                board[0][1] = OO;
                return;
            } else {
                if (board[1][0] == DASH) {
                    board[1][0] = OO;
                    return;
                }
            }
        }

        if (board[0][2] == OO) {
            if (board[1][2] == DASH) {
                board[1][2] = OO;
                return;
            }
        }

        if (board[2][0] == OO) {
            if (board[0][1] == DASH) {
                board[0][1] = OO;
                return;
            } else {
                if (board[2][1] == DASH) {
                    board[2][1] = OO;
                    return;
                }
            }
        }

        if (board[2][2] == OO) {
            if (board[1][2] == DASH) {
                board[1][2] = OO;
                return;
            } else {
                if (board[2][1] == DASH) {
                    board[2][1] = OO;
                    return;
                }
            }
        }
    }
}

public class Main {


    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        Board board = new Board();
        board.reset();
        board.setCell(0, 1,  Board.XX);
        board.dump();
        System.out.println(board.boardFull());

        for (int ii = 0; ii < 10; ii++) {
            board.aiMove();
            board.dump();
        }





        System.out.println("end");
    }
}
