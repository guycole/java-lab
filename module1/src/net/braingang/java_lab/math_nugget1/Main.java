package net.braingang.java_lab.math_nugget1;

public class Main {

    /**
     * Greatest Common Divisor
     * @param arg1
     * @param arg2
     * @return
     */
    public int gcd(int arg1, int arg2) {

        while (arg2 > 0) {
            int temp = arg2;
            arg2 = arg1 % arg2;
            arg1 = temp;
        }

        return arg1;
    }

    /**
     * Least Common Multiple
     * @param a
     * @param b
     * @return
     */
    private int lcm(int arg1, int arg2) {
        return arg1 * (arg2 / gcd(arg1, arg2));
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        System.out.println(main.gcd(8, 12));
        System.out.println(main.lcm(4, 6));

        System.out.println("end");
    }
}
