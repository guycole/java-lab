package net.braingang.philosopher1;

public class Main {

    class Philosopher implements Runnable {
        private Object leftFork;
        private Object rightFork;

        public Philosopher(Object leftFork, Object rightFork) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " " + action);
            Thread.sleep(((int) (Math.random() * 100)));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    doAction(System.nanoTime() + ": Thinking");
                    synchronized (leftFork) {
                        doAction(System.nanoTime() + ": Picked up left fork");
                        synchronized (rightFork) {
                            doAction(System.nanoTime() + ": Picked up right fork - eating");
                            doAction(System.nanoTime() + ": Put down right fork");
                        }

                        doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
                    }
                }
            } catch(InterruptedException exception) {
                System.out.println("exception noted");
                return;
            }
        }
    }

    public Main() {
        System.out.println("ctor");
    }

    public void execute() {
        final Philosopher[] philosophers = new Philosopher[5];

        Object[] forks = new Object[philosophers.length];
        for (int ii = 0; ii < forks.length; ii++) {
            forks[ii] = new Object();
        }

        for (int ii = 0; ii < philosophers.length; ii++) {
            Object leftFork = forks[ii];
            Object rightFork = forks[(ii + 1) % forks.length];

            if (ii == philosophers.length -1) {
                philosophers[ii] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[ii] = new Philosopher(leftFork, rightFork);
            }

            Thread thread = new Thread(philosophers[ii], "Philosopher " + (ii + 1));
            thread.start();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }
}