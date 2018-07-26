package net.braingang.java_lab.queue1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

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
        //return max priority
        return c2.getPriority().compareTo(c1.getPriority());

       //return min priority
       //return c1.getPriority().compareTo(c2.getPriority());
    }
}


public class Main {

    public void execute(Container[] candidates) {
        Queue<Container> priorityQueue = new PriorityQueue<>(new PriorityCompare());

        for (Container temp:candidates) {
            priorityQueue.add(temp);
        }

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
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
        main.execute(candidates);

        System.out.println("end");
    }
}
