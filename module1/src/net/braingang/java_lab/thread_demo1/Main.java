package net.braingang.java_lab.thread_demo1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class TestMessage {
    private String message;

    public TestMessage(String arg) {
        message = arg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String arg) {
        message = arg;
    }
}

class Waiter implements Runnable {
    private TestMessage message;

    public Waiter(TestMessage arg) {
        message = arg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (message) {
            try {
                System.out.println(name + " waiting to get notified:" + System.currentTimeMillis());
                message.wait();
            } catch(InterruptedException exception) {
                exception.printStackTrace();
            }

            System.out.println(name + " waiter thread notified at:" + System.currentTimeMillis());
            System.out.println(name + " processed:" +  message.getMessage());
        }
    }
}

class Notifier implements Runnable {
    private TestMessage message;

    public Notifier(TestMessage arg) {
        message = arg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        try {
            Thread.sleep(1000L);
            synchronized (message) {
                message.setMessage(name + " notifier work done");
                //message.notify();;
                message.notifyAll();
            }
        } catch(InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

public class Main {
    public String reverser(String arg) {
        System.out.println(arg);

        int limit = arg.length();
        char[] buffer = new char[limit];

        int ndx1, ndx2 = limit-1;
        for (ndx1 = 0; ndx1 < limit; ndx1++) {
            char temp = arg.charAt(ndx1);
            buffer[ndx2--] = temp;
        }

        return new String(buffer);
    }

    public int finder1(int target, int[] candidates) {
        int limit = candidates.length;
        int ndx1 = Arrays.binarySearch(candidates, 0, limit, target);
        System.out.println("ndx1:" + ndx1);

        Arrays.sort(candidates);
        for (int ndx2 = 0; ndx2 < candidates.length; ndx2++) {
            System.out.println(candidates[ndx2]);
        }

        return 6666;
    }

    public void linkedList(int[] candidates) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int ndx1 = 0; ndx1 < candidates.length; ndx1++) {
            //System.out.println(candidates[ndx1]);
            linkedList.add(candidates[ndx1]);
        }

        for (int temp: linkedList) {
            System.out.println(temp);
        }
    }

    public void hashMap(int[] candidates) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int temp: candidates) {
            System.out.println(temp);

            Integer counter = hashMap.get(temp);
            if (counter == null) {
                hashMap.put(temp, 1);
            } else {
                hashMap.put(temp, counter+1);
            }
        }

        for (Map.Entry entry:hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void treeMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");

        for (Map.Entry<Integer, String> entry:treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void threadDemo() {
        TestMessage message = new TestMessage("first message");
        Waiter waiter1 = new Waiter(message);
        new Thread(waiter1, "waiter1").start();

        Waiter waiter2 = new Waiter(message);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "notifier").start();

        System.out.println("all threads started");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Main main = new Main();
        System.out.println(main.reverser("bogus"));

        int[] candidates = {1, 2, 3, 4, 5};
        Arrays.sort(candidates);

        System.out.println(main.finder1(4, candidates));

        main.linkedList(candidates);

        main.hashMap(candidates);

        main.treeMap();

        main.threadDemo();
    }
}
