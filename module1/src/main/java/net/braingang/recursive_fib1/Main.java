package net.braingang.recursive_fib;

public class Main {
    /*
    ** 1, 1, 2, 3, 5, 8, 13, 21...
    ** big O = O(2^n)
    **
    */

    public Main() {
        System.out.println("ctor");
    }

    public int fib1(int n) {
    //    System.out.println(n);

        if (n <= 1) return n;

        return fib1(n-1)+fib1(n-2);
    }

    int[] cache = new int[100];

    public int fib2(int n) {
        // big O = O(n)
        //    System.out.println(n);

        if (n <= 1) return n;
        if (cache[n] != 0) return cache[n];
        cache[n] = fib2(n-1)+fib2(n-2);
        return cache[n];
    }

    public static void main(String[] args) {
        // big O = O(2^n)
        System.out.println("begin");

        Main main = new Main();

        for (int ii = 0; ii < 7; ii++) {
            System.out.println(ii + ":" + main.fib1(ii));
        }

        for (int ii = 0; ii < 7; ii++) {
            System.out.println(ii + ":" + main.fib2(ii));
        }

        System.out.println("end");
    }
}