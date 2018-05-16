package net.braingang.quick_sort1;

import java.util.Random;

public class Main {
    /*
    ** quick sort
    ** place items below or above "pivot"
    ** big O = O(n^2) which happens when pivot contains smallest or largest item
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

    int partition(int[] candidates, int low, int high) {
        System.out.println(low + ":" + high);
        int pivot = candidates[high];

        int ii = (low - 1);
        for (int jj = low; jj < high; jj++) {
            if (candidates[jj] <= pivot) {
                ii++;

                System.out.println("swap1:" + ii + ":" + jj);
                int temp = candidates[ii];
                candidates[ii] = candidates[jj];
                candidates[jj] = temp;
            }
        }

        System.out.println("swap2:" + (ii+1) + ":" + high);
        int temp = candidates[ii+1];
        candidates[ii+1] = candidates[high];
        candidates[high] = temp;

        return ii+1;
    }

    public void quickSort(int[] candidates, int low, int high) {
        arrayDump(candidates);

        if (low < high) {
            int partition_ndx = partition(candidates, low, high);
            quickSort(candidates, low, partition_ndx-1);
            quickSort(candidates, partition_ndx+1, high);
        }

        arrayDump(candidates);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < candidates.length; ii++) {
            candidates[ii] = random.nextInt(1000);
   //         candidates[ii] = ii;
        }

        Main main = new Main();
        main.quickSort(candidates, 0, candidates.length-1);

        System.out.println("end");
    }
}