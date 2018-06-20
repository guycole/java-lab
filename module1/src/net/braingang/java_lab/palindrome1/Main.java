package net.braingang.java_lab.palindrome1;

public class Main {

    private int advance(char[] array, int origin) {
        while (++origin < array.length) {
            char cc = array[origin];
            if (Character.isLetterOrDigit(cc)) break;
        }

        return origin;
    }

    private int retreat(char[] array, int origin) {
        while (--origin >= 0) {
            char cc = array[origin];
            if (Character.isLetterOrDigit(cc)) break;
        }

        return origin;
    }

    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();

        char c1 = 'a';
        char c2 = 'b';

        int ndx1 = -1;
        int ndx2 = array.length;

        boolean flag = true;

        while (flag) {
            ndx1 = advance(array, ndx1);
            ndx2 = retreat(array, ndx2);

            if ((ndx1 > array.length) || (ndx2 < 0)) {
                flag =  false;
            } else {
                System.out.println("ndx1:" + ndx1 + ":" + array[ndx1]);
                System.out.println("ndx2:" + ndx2 + ":" + array[ndx2]);

                if (Character.toLowerCase(array[ndx1]) != Character.toLowerCase(array[ndx2])) {
                    System.out.println("match failure");
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
//       System.out.println(main.isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(main.isPalindrome("race a car"));
        System.out.println(main.isPalindrome("a."));

        System.out.println("end");
    }
}
