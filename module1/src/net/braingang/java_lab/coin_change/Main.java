package net.braingang.java_lab.coin_change;

import java.util.Arrays;

public class Main {
    int counter = 0;

    // o = 2^n

    public int recursive1(int amount, int[] values, int ndx) {
        ++counter;

        //System.out.println("amount:" + amount + ":values:"+  values.length + ":ndx:" + ndx + ":");

        if (amount < 0) {
            return 0;
        }

        if (amount == 0) {
            //System.out.println("winner");
            //System.out.println(ndx + ":" + values[ndx]);
            return 1;
        }

        // means coins over and n>0 so no solution
        if (ndx == values.length && amount > 0) {
            return 0;
        }

        int x1 = recursive1(amount - values[ndx], values, ndx);
        //System.out.println("-o-o-o-" + x1);
        int x2 = recursive1(amount, values, ndx + 1);
        //System.out.println("x1:" + x1 + ":x2:" + x2 + ":total:"+ (x1+x2));
        //System.out.println("-x-x-x-x-");
        return(x1 + x2);

        //return total(n - values[ndx], values, ndx) + total(n, values, ndx + 1);
    }

    public void x2(int amount, int[] values) {
        int[] result = new int[amount+1];
        int[] track = new int[amount+1];

        result[0] = 0;
        track[0] = -1;

        for (int ii = 1; ii <= amount; ii++) {
            result[ii] = Integer.MAX_VALUE-1;
            track[ii] = -1;
        }

        for (int value:values) {
            for (int amt = 1; amt <= amount; amt++) {
                if (value <= amt) {
                    if (result[amt] < (result[amt-value]+1)) {
                        // empty
                    } else {
                        result[amt] = 1 + result[amt-value];
                        track[amt] = value;
                    }
                }
            }
        }

        System.out.println("min:" + result[amount]);

        int pos = amount;
        while (pos != 0) {
            System.out.print(track[pos] + ":");
            pos = pos-track[pos];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int amount = 5;
        int[] values = { 1, 2, 3 };
        System.out.println("population from recursion: " + main.recursive1(amount, values, 0));
        System.out.println("counter:" + main.counter);

        main.x2(amount, values);

        System.out.println("end");
    }
}
