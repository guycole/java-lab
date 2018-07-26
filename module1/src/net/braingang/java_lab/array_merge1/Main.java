package net.braingang.java_lab.array_merge1;

import java.util.Arrays;

public class Main {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int ndx2 = 0; ndx2 < nums2.length; ndx2++) {
            System.out.println("top:" + ndx2 + ":" + nums2[ndx2]);

            int ndx1 = 0;
            while ((ndx1 < nums1.length) && (nums1[ndx1] <= nums2[ndx2]) && (nums1[ndx1] > 0)) {
                System.out.println(nums1[ndx1] + ":" + nums2[ndx2]);
                ++ndx1;
            }

            if (ndx1 < nums1.length) {
                System.out.println("insert:" + ndx1 + ":" + ndx2);

                for (int ndx3 = nums1.length -2; ndx3 >= ndx1; ndx3--) {
                    nums1[ndx3 + 1] = nums1[ndx3];
                }

                nums1[ndx1] = nums2[ndx2];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        int[] input1 = {1, 2, 3, 0, 0, 0};
        int[] input2 = {2, 5, 6};

        Main main = new Main();
        main.merge(input1, input1.length, input2, input2.length);

        System.out.println(Arrays.toString(input1));

        System.out.println("end");
    }
}
