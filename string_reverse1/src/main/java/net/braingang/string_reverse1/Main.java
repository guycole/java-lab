package net.braingang.string_reverse1;

public class Main {

    public Main() {
        System.out.println("ctor");
    }

    public String execute(String arg) {
        StringBuffer sb = new StringBuffer();

        for (int ii = arg.length()-1; ii >= 0; ii--) {
            sb.append(arg.charAt(ii));
        }

        return(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();

        System.out.println(main.execute("testaroo"));

        System.out.println("end");
    }
}