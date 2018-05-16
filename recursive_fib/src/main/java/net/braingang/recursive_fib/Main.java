package net.braingang.recursive_fib;

public class Main {
    /*
    ** 1, 1, 2, 3, 5, 8, 13, 21...
    * big O = O(2^n)
    **
    */

    public Main() {
        System.out.println("ctor");
    }

    public int fib(int n) {
    //    System.out.println(n);

        if (n <= 1) return n;

        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        for (int ii = 0; ii < 7; ii++) {
            System.out.println(ii + ":" + main.fib(ii));
        }

        System.out.println("end");
    }
}