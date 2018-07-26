package net.braingang.java_lab.recurse1;

public class Main {

    public int recurse1(int limit) {
        int result = 0;

        System.out.println(limit);

        if (limit > 0) {
            result = recurse1(limit-1) + limit;
        }

//        def sumIntsToRecursive(i: Int) : Int = if (i == 0) 0 else i + sumIntsToRecursive(i - 1)


        System.out.println("back:" + limit + ":" + result);
        return result;
    }


    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        System.out.println(main.recurse1(3));



        System.out.println("end");
    }
}
