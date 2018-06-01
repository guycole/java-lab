package net.braingang.insertion_sort1;

import java.util.Random;

public class Main {
    /*
     ** insertion sort, find proper location, move array down, efficient for small data sets
     ** big O = O(n^2) best for data which is already mostly sorted
     ** memory is O(1)
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

    public void insertionSort(int[] target) {
        arrayDump(target);

        for (int ii = 1; ii < target.length; ii++) {
            int jj = ii-1;
            int key = target[ii];

            while (jj >= 0 && target[jj] > key) {
                target[jj+1] = target[jj];
                --jj;
            }

            target[jj+1] = key;

            arrayDump(target);
        }

        arrayDump(target);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < 10; ii++) {
            candidates[ii] = random.nextInt();
            candidates[ii] = ii;
        }

        Main main = new Main();
        main.insertionSort(candidates);

        System.out.println("end");
    }
}