package dekker;

/**
 * Implementation of Dekker's algorithm.
 *
 * <p>Name: Frank Garcia
 * <p>Date: 11/23/16
 * <p>Assignment: 21
 *
 * <p>File:
 * <code>Dekker.java</code>
 *
 * @author Name
 */

public class Dekker extends Thread {
    static volatile int n = 0;
    static volatile boolean want = false;
    static volatile int turn = 1;
    int processID;

    Dekker(int pID) {
        processID = pID;
    }

    public void run() {
        int temp, delay;
        if (processID == 1) { // process p
            for (int i = 0; i < 15; i++) {
                try {
                // non-critical section
                System.out.println("p" + processID + ".i = " + i);
                // preprotocol
                want = true;
                while (want) {
                    if (turn == 2) {
                        want = false;
                        while (turn != 1);
                        want = true; 
                    }
                }
                // critical section
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                temp = n;
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                n = temp + 1;
                // postprotocol
                turn = 2;
                want = false;
            } catch (InterruptedException e) {
            }
            }
        } else { // processID == 2, process q
            for (int i = 0; i < 10; i++) {
                try {
                // non-critical section
                System.out.println("p" + processID + ".i = " + i);
                // preprotocol
                want = true;
                while (want) {
                    if (turn == 1) {
                        want = false;
                        while (turn != 2);
                        want = true;
                    }
                }
                // critical section
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                temp = n;
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                n = temp + 1;
                // postprotocol
                turn = 1;
                want = false;
            } catch (InterruptedException e) {
            }
            }
        }
    }

    public static void main(String[] args) {
        Dekker p1 = new Dekker(1);
        Dekker p2 = new Dekker(2);
        p1.start();
        p2.start();
        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n);
    }
}
