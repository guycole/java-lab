package net.braingang.java_lab.heap_sort1;

import java.util.Arrays;

public class Main {
    //build heap is O(n)
    //total running time is n log n
    //this example not work

    private void percolateDown(int[] candidates, int ndx, int limit) {
        int child;
        int temp;

        for (temp = candidates[ndx]; ndx*2 <= limit; ndx = child) {
            child = ndx*2;
            if ((child != limit) && (candidates[child+1] > candidates[child])) {
                ++child;
            }

            if (temp < candidates[child]) {
                candidates[ndx] = candidates[child];
            } else {
                break;
            }
        }

        candidates[ndx] = temp;
    }

    public void heapSort(int[] candidates) {
        for (int ii = candidates.length/2; ii > 0; ii--) {
            percolateDown(candidates, ii, candidates.length);
        }

        for (int ii = candidates.length; ii >= 2; ii--) {
            int temp = candidates[1];
            candidates[1] = candidates[ii];
            candidates[ii] = temp;

            percolateDown(candidates, 1, ii-1);
        }
    }


    public static void main(String[] args) {
        System.out.println("begin");

        int[] candidates = {31, 41, 59, 26, 53, 58, 97};

        Main main = new Main();
        System.out.println(Arrays.toString(candidates));
        main.heapSort(candidates);
        System.out.println(Arrays.toString(candidates));

        System.out.println("end");
    }
}
