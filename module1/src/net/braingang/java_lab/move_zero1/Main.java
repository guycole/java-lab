package net.braingang.java_lab.move_zero1;

import java.util.Arrays;

public class Main {

    public void moveZeroes(int[] nums) {
        for (int ii = 0; ii < nums.length; ii++) {
            int counter = 0;

            while (nums[ii] == 0) {
                if (counter > nums.length-ii) {
                    break;
                } else {
                    ++counter;
                }

                for (int jj = ii; jj < nums.length-1; jj++) {
                    nums[jj] = nums[jj+1];
                }

                nums[nums.length-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int[] input1 = {0, 1, 0, 3, 12};
        int[] output1 = {1, 3, 12, 0, 0};
//        main.moveZeroes(input1);
        System.out.println(Arrays.toString(input1));

        int[] input2 = {0, 0, 1};
        int[] output2 = {1, 0, 0};
        main.moveZeroes(input2);
        System.out.println(Arrays.toString(input2));

        System.out.println("end");
    }
}
