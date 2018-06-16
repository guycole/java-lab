package net.braingang.java_lab.merge_sort1;

import java.util.Random;

public class Main {
    /*
     ** merge sort
     ** runtime average big O = O(n log n)
     ** merge two single element arrays
     ** memory big O = varies
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

    public void merge(int[] candidates, int left_ndx, int middle_ndx, int right_ndx) {
        int n1 = middle_ndx - left_ndx + 1;
        int n2 = right_ndx - middle_ndx;

        int[] left_array = new int[n1];
        int[] right_array = new int[n2];

        for (int ii = 0; ii < n1; ++ii) {
            left_array[ii] = candidates[left_ndx + ii];
        }

        for (int ii = 0; ii < n2; ++ii) {
            right_array[ii] = candidates[middle_ndx + 1 + ii];
        }

        int ii = 0, jj = 0, kk = left_ndx;
        while (ii < n1 && jj < n2) {
            if (left_array[ii] <= right_array[jj]) {
                candidates[kk] = left_array[ii];
                ii++;
            } else {
                candidates[kk] = right_array[jj];
                jj++;
            }

            kk++;
        }

        while (ii < n1) {
            candidates[kk] = left_array[ii];
            ii++;
            kk++;
        }

        while (jj < n2) {
            candidates[kk] = right_array[jj];
            jj++;
            kk++;
        }
    }

    public void mergeSort(int[] candidates, int left, int right) {
        System.out.println(left + ":" + right);
        arrayDump(candidates);

        if (left < right) {
            int middle = (left + right)/2;
            mergeSort(candidates, left, middle);
            mergeSort(candidates, middle+1, right);
            merge(candidates, left, middle, right);
        }

        arrayDump(candidates);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < 10; ii++) {
            candidates[ii] = random.nextInt();
    //        candidates[ii] = ii;
        }

        Main main = new Main();
        main.mergeSort(candidates, 0, candidates.length-1);

        System.out.println("end");
    }
}