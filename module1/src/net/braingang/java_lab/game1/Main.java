package net.braingang.java_lab.game1;

import java.util.Arrays;

public class Main {

    public boolean canWin(int leap, int[] game) {
        System.out.println(Arrays.toString(game));

        boolean counting = false;
        int currentConsecutive = 0;
        int maxConsecutive = 0;
        for (int ii = 0; ii < game.length; ii++) {
            if (game[ii] > 0) {
                ++currentConsecutive;
            } else {
                if (currentConsecutive > maxConsecutive) {
                    maxConsecutive = currentConsecutive;
                }

                currentConsecutive = 0;
            }
        }

        if (currentConsecutive > maxConsecutive) {
            maxConsecutive = currentConsecutive;
        }

        System.out.println("out:" + maxConsecutive);

        if (maxConsecutive >= leap) {
            System.out.println("shortcut");
            return false;
        }

        int currentNdx = 0;
        boolean loopFlag = true;

        while (loopFlag) {
            System.out.println("top:" + currentNdx);

            if (currentNdx+leap >= game.length) {
                System.out.println("out from leap");
                return true;
            }

            if ((currentNdx+leap < game.length) && (game[currentNdx+leap] == 0)) {
                currentNdx += leap;
                game[currentNdx] = -1;
            } else if ((currentNdx+1 < game.length) && (game[currentNdx+1] == 0)) {
                currentNdx += 1;
                game[currentNdx] = -1;
            } else if ((currentNdx-1 >= 0) && (game[currentNdx-1] == 0)) {
                currentNdx -= 1;
                game[currentNdx] = -1;
            } else {
                return false;
            }

            System.out.println(Arrays.toString(game));
        }

        return false;

        //return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("begin");

        Main main = new Main();

        int leap1 = 3;
        int[] game1 = {0, 0, 0, 0, 0};
        System.out.println("true:" + main.canWin(leap1, game1));

        int leap2 = 5;
        int[] game2 = {0, 0, 0, 1, 1, 1};
        System.out.println("true:" + main.canWin(leap2, game2));

        int leap3 = 3;
        int[] game3 = {0, 0, 1, 1, 1, 0};
        System.out.println("false:" + main.canWin(leap3, game3));

        int leap4 = 1;
        int[] game4 = {0, 1, 0};
        System.out.println("false:" + main.canWin(leap4, game4));

        int leap5 = 2;
        int[] game5 = {0, 1, 0, 1, 0, 1};
        System.out.println("true:" + main.canWin(leap5, game5));

        int leap6 = 6;
        int[] game6 = {0, 0, 1, 1, 0, 0, 1, 1, 0, 0};
        System.out.println("false:" + main.canWin(leap6, game6));

        /*
        int leap55 = 41;
        int[] game55 = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1};
        System.out.println("false:" + main.canWin(leap55, game55));
        */

        System.out.println("end");
    }
}