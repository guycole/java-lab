package net.braingang.java_lab.magic_square1;

public class Main {

    /*
    ** magic square for odd sized squares M = n(n^2+1)/2
    */
    public Main() {
        System.out.println("ctor");
    }

    public void magicSquare(int size) {
        int[][] square = new int[size][size];

        int ii = size / 2;
        int jj = size - 1;

        for (int kk = 1; kk <= size * size;) {
            if (ii == -1 && jj == size) {
                jj = size - 2;
                ii = 0;
            } else {
                if (jj == size) jj = 0;
                if (ii < 0) ii = size - 1;
            }

            if (square[ii][jj] != 0) {
                jj -= 2;
                ii++;
                continue;
            } else {
                square[ii][jj] = kk++;
            }

            jj++;
            ii--;
        }

        for (ii = 0; ii < size; ii++) {
            for (jj = 0; jj < size; jj++) {
                System.out.print(square[ii][jj] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        main.magicSquare(6);
     //   main.generateSquare(6);

        System.out.println("end");
    }
}