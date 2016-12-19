package alg0306;

/**
 * Implementation of Algorithm 3.6 of M. Ben-Ari, <i>Principles of Concurrent
 * and Distributed Programming</i>, Second edition, Addison Wesley, 2006.
 *
 * <p>Name: Frank Garcia
 * <p>Date: 11/18/16
 * <p>Assignment: 20
 *
 * <p>File:
 * <code>Alg0306.java</code>
 *
 * @author Name
 */

// Following code from Algorithm 3.2 to be modified.
public class Alg0306 extends Thread {

    static volatile int n = 0;
    static volatile boolean want  = false;
    int processID;

    Alg0306(int pID) {
        processID = pID;
    }

    public void run() {
        int temp, delay;
        for (int i = 0; i < 10; i++) {
            try {
                // non-critical section
                System.out.println("p" + processID + ".i = " + i);
                // preprotocol
                while (want);
                want = true;
                // critical section
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                temp = n;
                delay = (int) (100 * Math.random());
                Thread.sleep(delay);
                n = temp + 1;
                // postprotocol
                want = false; 
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        Alg0306 p1 = new Alg0306(1);
        Alg0306 p2 = new Alg0306(2);
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
