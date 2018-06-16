package net.braingang.java_lab.iterator1;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoIterator<DemoContainer> implements Iterator {

    private ArrayList<?> targets;
    private int ndx;

    public DemoIterator(DemoList original) {
        targets = original.getList();
    }

    @Override
    public boolean hasNext() {
        if (ndx < targets.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object temp = targets.get(ndx++);
        return temp;
    }
}
