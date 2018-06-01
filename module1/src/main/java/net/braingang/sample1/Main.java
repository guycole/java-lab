package net.braingang.sample1;

public class Main {

    public Main() {
        System.out.println("ctor");
    }

    public static void main(String[] args) {
        System.out.println("begin2xx");

        Main main = new Main();

        System.out.println("end2xx");
    }
}