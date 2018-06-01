package net.braingang.bubble_sort1;

import java.util.Random;

public class Main {
    /*
     ** bubble sort, swap adjacent elements - always makes at least one pass - widely criticized
     ** runtime average big O = O(n^2)
     ** memory big O = O(1)
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

    public void bubbleSort(int[] target) {
        arrayDump(target);

        int counter = 0;
        boolean swap_flag;

        do {
            ++counter;
            swap_flag = false;

            for (int ii = 0; ii < target.length-1; ii++) {
                int left = target[ii];
                int right = target[ii+1];

                if (left > right) {
                    swap_flag = true;

                    target[ii] = right;
                    target[ii+1] = left;
                }
            }
        } while (swap_flag);


        arrayDump(target);
        System.out.println("counter:" + counter);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];


        for (int ii = 0; ii < 10; ii++) {
            candidates[ii] = random.nextInt();
//          candidates[ii] = ii;
        }

        Main main = new Main();
        main.bubbleSort(candidates);

        System.out.println("end");
    }
}