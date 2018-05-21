package net.braingang.permute1;

import java.util.Set;
import java.util.HashSet;

public class Main {

    public Main() {
        System.out.println("ctor");
    }

    public int factorial(int arg) {
        int result = 1;

        if (arg < 1) {
            return result;
        }

        for (int ii = 1; ii <= arg; ii++) {
            result *= ii;
        }

        return result;
    }

    public String charInserter(String arg, char cc, int ii) {
        String begin = arg.substring(0, ii);
        String end = arg.substring(ii);
        String result = begin + cc + end;
    //    System.out.println(result);
        return result;
    }

    public Set<String> permute(String arg) {
        Set<String> result = new HashSet<String>();

        if (arg == null) {
            return null;
        } else if (arg.length() == 0) {
            result.add("");
            return result;
        }

        char initial = arg.charAt(0);
        String remainder = arg.substring(1);
        Set<String> tokens = permute(remainder);
        for (String current:tokens) {
            for (int ii = 0; ii <= current.length(); ii++) {
                result.add(charInserter(current, initial, ii));
            }
        }

        return result;
    }

    public void permute2(String arg) {
        System.out.println(arg);

        char[] candidates = arg.toCharArray();

        int max_solutions = factorial(candidates.length);
        System.out.println("max solutions:" + max_solutions);

        do {
            for (int ii = 0; ii < candidates.length; ii++) {
                for (int jj = 0; jj < ii; jj++) {
                    char temp = candidates[jj];
                    candidates[jj] = candidates[jj+1];
                    candidates[jj+1] = temp;

                    System.out.println(new String(candidates));
                }
            }
        } while (!arg.equals(new String(candidates)));

            /*
        for (int ii = 0; ii < max_solutions; ii++) {
            //System.out.println("ii:" + ii);
            //System.out.println(ii + ":" + new String(candidates));

            for (int jj = 0; jj < candidates.length-1; jj++) {
                char temp = candidates[jj];
                candidates[jj] = candidates[jj+1];
                candidates[jj+1] = temp;

                System.out.println(new String(candidates));
            }

        }
        */
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        //Set<String> xx = main.permutationFinder("abc");
        Set<String> xx = main.permute("abce");
        System.out.println(xx.size());
        for (String yy:xx) {
            System.out.println(yy);
        }

        System.out.println("end");
    }
}