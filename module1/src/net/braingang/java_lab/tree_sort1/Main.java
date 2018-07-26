package net.braingang.java_lab.tree_sort1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * sort container by priority
 */
class Container {
    private int key;
    private int priority;

    public Container(int key, int priority) {
        this.key = key;
        this.priority = priority;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getPriority() {
        return priority;
    }

    public String toString() {
        return key + ":" + priority;
    }
}

class PriorityCompare implements Comparator<Container> {
    @Override
    public int compare(Container c1, Container c2) {
        return c1.getPriority().compareTo(c2.getPriority());
    }
}

public class Main {

    public Main() {
        System.out.println("ctor");
    }

    public void treeSort(Container[] candidates) {
        TreeMap<Integer, Container> treeMap = new TreeMap<Integer, Container>();

        for (Container current:candidates) {
            treeMap.put(current.getKey(), current);
        }

        /*
        TreeMap<Container, Integer> treeMap = new TreeMap<Container, Integer>(new PriorityCompare());

        for (Container current:candidates) {
            treeMap.put(current, current.getKey());
        }
        */

        /*
        Set set = treeMap.entrySet();
        Iterator ii = set.iterator();
        while (ii.hasNext()) {
            Map.Entry me = (Map.Entry) ii.next();
            System.out.println(me.getKey() + ":" + me.getValue());
        }
        */

        NavigableSet<Integer> navigableSet = treeMap.descendingKeySet();
        for (Integer container:navigableSet) {
            System.out.println("xx:" + container);
        }

        System.out.println("-x-x-x-x-");
        Collection c = treeMap.values();
        Iterator itr = c.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }

    public static void main(String[] args) {
        System.out.println("begin");

        Random random = new Random();

        Container[] candidates = new Container[10];

        for (int ii = 0; ii < candidates.length; ii++) {
            candidates[ii] = new Container(ii, random.nextInt(1000));
        }

        candidates[9] = new Container(9, candidates[8].getPriority());

        Main main = new Main();
        main.treeSort(candidates);

        System.out.println("end");
    }
}