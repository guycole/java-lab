package net.braingang.java_lab.iterator1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public void execute() {

        DemoContainer target1 = new DemoContainer("target1");
        System.out.println(target1);
        DemoContainer target2 = new DemoContainer("target2");
        System.out.println(target2);

        System.out.println(target1.hashCode());
        System.out.println(target2.hashCode());

        System.out.println(target1.equals(null));
        Integer bogus = new Integer(5);
        System.out.println(target1.equals(bogus));
        System.out.println(target1.equals(target1));
        System.out.println(target1.equals(target2));

        System.out.println(target1.compareTo(target2));
        System.out.println(target1.compareTo(target1));
        System.out.println(target2.compareTo(target1));

        ArrayList<DemoContainer> originalList = new ArrayList<>();
        originalList.add(target1);
        originalList.add(target2);
        originalList.add(new DemoContainer("target5"));
        originalList.add(new DemoContainer("target4"));
        originalList.add(new DemoContainer("target3"));

        DemoList targetList = new DemoList(originalList);
        for (DemoContainer current:targetList) {
            System.out.println(current);
        }

        Collections.sort(originalList, new DemoComparator());
        System.out.println(originalList.toString());

       // Collections.sort(targetList);

      //  Arrays.sort(targetList);
      //  System.out.println(Arrays.toString(targetlList));

    }

    public static void main(String[] args) {
        System.out.println("begin");

        Main main = new Main();
        main.execute();

        System.out.println("end");
    }
}
