package net.braingang.java_lab.iterator1;

import java.util.ArrayList;
import java.util.Iterator;

public class DemoList implements Iterable<DemoContainer> {

    private ArrayList<DemoContainer> targets = new ArrayList<>();

    public DemoList(ArrayList<DemoContainer> arg) {
        targets = arg;
    }

    public ArrayList<DemoContainer> getList() {
        return targets;
    }

    @Override
    public Iterator<DemoContainer> iterator() {
        return new DemoIterator(this);
    }
}
