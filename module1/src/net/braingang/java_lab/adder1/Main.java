package net.braingang.java_lab.adder1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> buffer = new ArrayList<>();

        int carry = 1;

        for (int ii = digits.length -1; ii >= 0; ii--) {
            int value = digits[ii] + carry;
            if (value > 9) {
                carry = value / 10;
                value = value % 10;
            } else {
                carry = 0;
            }

            buffer.add(value);
        }

        if (carry > 0) {
            buffer.add(carry);
        }

        int[] result = new int[buffer.size()];

        int jj = buffer.size() -1;
        for (int ii = 0; ii < buffer.size(); ii++) {
            result[ii] = buffer.get(jj--);
        }

        return result;
    }

    /*
    public int[] plusOne(int[] digits) {
        long multiplier = 1;
        long total = 0;

        int place = 1;
        for (int ii = digits.length -1; ii >= 0; ii--) {
            total += (digits[ii] * multiplier);
            multiplier *= 10;
        }

        System.out.println(total);

        total += 1;

        String buffer = Long.toString(total);
        int[] result = new int[buffer.length()];
        for (int ii = 0; ii < buffer.length(); ii++) {
            char cc = buffer.charAt(ii);
            result[ii] = Character.digit(cc, 10);
        }

        return result;
    }
    */

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        int[] input1 = {1, 2, 3, 4};
        int[] output1 = {1, 2, 3, 5};
        int[] result1 = main.plusOne(input1);
        System.out.println(Arrays.toString(result1));

        int[] input2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] output2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        int[] result2 = main.plusOne(input2);
        System.out.println(Arrays.toString(result2));

        int[] input3 = {9};
        int[] output3 = {1, 0};
        int[] result3 = main.plusOne(input3);
        System.out.println(Arrays.toString(result3));

        System.out.println("end");
    }
}
