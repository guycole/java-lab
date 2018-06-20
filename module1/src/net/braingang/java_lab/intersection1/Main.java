package net.braingang.java_lab.intersection1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public int[] intersect(int[] nums1, int[] nums2) {
        if ((nums1.length < 1) || (nums2.length < 1)) {
            return new int[0];
        }

        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for (int ii = 0; ii < nums1.length; ii++) {
            Integer key = new Integer(nums1[ii]);
            Integer value = hm1.get(key);
            if (value == null) {
                hm1.put(key,1);
            } else {
                hm1.put(key, value.intValue()+1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int ii = 0; ii < nums2.length; ii++) {
            Integer key = new Integer(nums2[ii]);
            if (hm1.containsKey(key)) {
                arrayList.add(key);
                int value = hm1.get(key);
                value -= 1;
                if (value < 1) {
                    hm1.remove(key);
                } else {
                    hm1.put(key, value);
                }
            }
        }

        int[] result = new int[arrayList.size()];

        int ndx = 0;
        for (Integer current:arrayList) {
            result[ndx++] = current;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        // random and duplicate
        int[] input1a = {1, 2, 2, 1};
        int[] input2a = {2, 2};

        Main main = new Main();
        int[] result = main.intersect(input1a, input2a);
        System.out.println(Arrays.toString(result));

        System.out.println("end");
    }
}
