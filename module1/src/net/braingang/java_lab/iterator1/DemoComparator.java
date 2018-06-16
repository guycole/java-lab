package net.braingang.java_lab.iterator1;

import java.util.Comparator;

public class DemoComparator implements Comparator<DemoContainer> {

    @Override
    public int compare(DemoContainer arg1, DemoContainer arg2) {
        return arg1.compareTo(arg2);
    }
}
