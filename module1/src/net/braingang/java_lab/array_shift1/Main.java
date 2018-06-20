package net.braingang.java_lab.array_shift1;

import java.util.Arrays;

public class Main {

    public void rotate(int[] nums, int k) {
        int kk = k % nums.length;

        if (kk < 1) return;

        int[] buffer = Arrays.copyOfRange(nums, nums.length-kk, nums.length);
        //System.out.println(Arrays.toString(buffer));

        for (int ii = nums.length-1; ii >= kk; ii--) {
            //System.out.println(ii + ":" + (ii-k) + ":");
            nums[ii] = nums[ii-kk];
        }

        for (int ii = 0; ii < buffer.length; ii++) {
            nums[ii] = buffer[ii];
        }

        System.out.println(Arrays.toString(nums));
        System.out.println("-xxxxxx-");

        /*
        for (int ii = 0; ii < k; ii++) {
            int temp = nums[nums.length-1];

            for (int jj = nums.length-1; jj > 0; jj--) {
                nums[jj] = nums[jj-1];
            }

            nums[0] = temp;
        }
        */
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        int[] output1 = {5, 6, 7, 1, 2, 3, 4};

        main.rotate(input1, 3);
        System.out.println("test1:" + Arrays.equals(input1, output1));

        int[] input2 = {-1, -100, 3, 99};
        int[] output2 = {3, 99, -1, -100};

        main.rotate(input2, 2);
        System.out.println("test2:" + Arrays.equals(input2, output2));
//        System.out.println(Arrays.toString(input2));

        int[] input3 = {1, 2};
        int[] output3 = {2, 1};

        main.rotate(input3, 3);
        System.out.println("test3:" + Arrays.equals(input3, output3));
        System.out.println(Arrays.toString(input3));

        System.out.println("end");
    }
}
