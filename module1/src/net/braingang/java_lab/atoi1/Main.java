package net.braingang.java_lab.atoi1;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public int atoi(String str) {
        System.out.println(str);

        Stack<Character> stack = new Stack<>();

        char[] original = str.toCharArray();

        boolean digitNoted = false;
        boolean negativeNoted = false;
        boolean positiveNoted = false;
        for (int ii = 0; ii < original.length; ii++) {
            if (original[ii] == ' ') {
                System.out.println("strip white space");

                if (digitNoted) {
                    break;
                }

                if (positiveNoted || negativeNoted) {
                    return 0;
                }
            } else if (original[ii] == '+') {
                System.out.println("plus noted");

                if (positiveNoted || negativeNoted || digitNoted) {
                    System.out.println("fail");
                    break;
                }
                positiveNoted = true;
            } else if (original[ii] == '-') {
                System.out.println("negative noted");
                if (positiveNoted || negativeNoted || digitNoted) {
                    System.out.println("fail");
                    break;
                }

                stack.push(original[ii]);
                negativeNoted = true;
            } else if (Character.isDigit(original[ii])) {
                System.out.println("digit");
                digitNoted = true;
                stack.push(original[ii]);
            } else {
                System.out.println("default");
                break;
            }
        }

        if (stack.size() < 1) {
            return 0;
        }

        char[] buffer = new char[stack.size()];
        for (int ii = buffer.length-1; ii >= 0; ii--) {
            buffer[ii] = stack.pop();
        }

        /*
        if (buffer.length > 11) {
            if (buffer[0] == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        */

        System.out.println(Arrays.toString(buffer));

        long result = 0;
        long multiplier = 1;

        for (int ii = buffer.length-1; ii >= 0; ii--) {
            if (buffer[ii] == '-') {
                result *= -1;
            } else {
                int current = Character.digit(buffer[ii], 10);
                result += current * multiplier;
                multiplier *= 10;
            }

            if (result > Integer.MAX_VALUE) {
                System.out.println("max max max max");
                if (buffer[0] == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            if (multiplier > Integer.MAX_VALUE) {
                System.out.println("mult mult mult");
                break;
            }
        }

        if (result > Integer.MAX_VALUE) {
            if (buffer[0] == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        System.out.println(main.atoi("42"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("4193 with words"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("words and 987"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("-91283472332"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("     -42"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("   +1"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("   +-1"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("9223372036854775808"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println("-x-x-x-x-");
        System.out.println(main.atoi("  0000000000012345678"));
        System.out.println("end");
    }
}
