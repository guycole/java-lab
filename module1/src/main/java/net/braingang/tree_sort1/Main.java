package net.braingang.tree_sort1;

import java.util.Random;

public class Main {

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

    public void treeSort(int[] candidates) {
        arrayDump(candidates);


        arrayDump(candidates);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        int[] candidates = new int[10];

        for (int ii = 0; ii < candidates.length; ii++) {
            candidates[ii] = random.nextInt(1000);
            candidates[ii] = ii;
        }

        Main main = new Main();
        main.treeSort(candidates);

        System.out.println("end");
    }
}