package net.braingang.java_lab.sort_dedupe1;

import java.util.*;

public class Main {

    public void dump(Integer[] arg) {
        for (int temp:arg) {
            System.out.print(temp + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("begin");

        // random and duplicate
        Integer[] buffer =  { 0, 10, 1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 5};

        Main main = new Main();
        main.dump(buffer);

        Set<Integer> hashSet = new HashSet<>();
        Collections.addAll(hashSet, buffer);
        System.out.println(hashSet.size());

        for (int temp:hashSet) {
            // no duplicates, and sorted.  why sorted?
            System.out.print(temp + " ");
        }
        System.out.println();

        Set<Integer> treeSet = new TreeSet<>();
        Collections.addAll(treeSet, buffer);

        for (int temp:hashSet) {
            // no duplicates, and sorted.
            System.out.print(temp + " ");
        }
        System.out.println();

        HashMap<String, Integer> hm1 = new HashMap<>();
        for (int ii = 0; ii < buffer.length; ii++) {
            hm1.put(Integer.toString(buffer[ii]), buffer[ii]);
        }
        System.out.println(hm1.size());

        Set<String> keys = hm1.keySet();
        for (String key:keys) {
            System.out.println(key + ":" + hm1.get(key));
        }

        System.out.println("end");
    }
}
