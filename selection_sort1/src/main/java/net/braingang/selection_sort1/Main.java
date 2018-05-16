package net.braingang.selection_sort1;

import java.util.Random;

public class Main {
    /*
     ** selection sort, find min element and swap, good if memory constrained
     ** big O = O(n^2)
     */

    public Main() {
        System.out.println("ctor");
    }

    public void arrayDump(int[] target) {
        StringBuffer sb = new StringBuffer();

        for (int ii = 0; ii < target.length; ii++) {
            sb.append(Integer.toString(target[ii]) + " ");
        }

        System.out.println(sb.toString());
    }

    public void selectionSort(int[] target) {
        arrayDump(target);

        int minimum_ndx = 0;

        for (int ii = 0; ii < target.length; ii++) {
            minimum_ndx = ii;

            for (int jj = ii + 1; jj < target.length; jj++) {
                if (target[minimum_ndx] > target[jj]) {
                    minimum_ndx = jj;
                }
            }

            int temp = target[ii];
            target[ii] = target[minimum_ndx];
            target[minimum_ndx] = temp;
        }

        arrayDump(target);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < 10; ii++) {
            candidates[ii] = random.nextInt();
 //           candidates[ii] = ii;
        }

        Main main = new Main();
        main.selectionSort(candidates);

        System.out.println("end");
    }
}