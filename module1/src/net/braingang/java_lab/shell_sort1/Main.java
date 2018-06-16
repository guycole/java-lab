package net.braingang.java_lab.shell_sort1;

import java.util.Random;

public class Main {
    /*
     ** shell sort, riff on insertion sort.
     ** insertion sort only moves one element at a time.
     ** shell sort moves far away
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

    public void shellSort(int[] candidates) {
        arrayDump(candidates);

        int limit = candidates.length;

        for (int ii = limit/2; ii > 0; ii /= 2) {
            for (int jj = ii; jj < limit; jj++) {
                int temp = candidates[jj];

                int kk;
                for (kk = jj; kk >= ii && candidates[kk-ii] > temp; kk -= ii) {
                    candidates[kk] = candidates[kk - ii];
                }

                candidates[kk] = temp;
            }
        }

        arrayDump(candidates);
    }

    public void shellSort2(int[] arr) {
        arrayDump(arr);
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }

        arrayDump(arr);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < candidates.length; ii++) {
            candidates[ii] = random.nextInt(1000);
         //   candidates[ii] = ii;
        }

        Main main = new Main();
        main.shellSort(candidates);

        System.out.println("end");
    }
}