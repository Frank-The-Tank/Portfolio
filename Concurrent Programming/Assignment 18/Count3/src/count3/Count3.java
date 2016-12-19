package count3;

/**
 * Name: Frank Garcia   
 * <p>Date: 11/10/16
 * <p>Assignment:18
 *
 * <p>File:
 * <code>Count3.java</code>
 *
 * @author Name
 */
public class Count3 extends Thread {

    static volatile int n = 0;
    int _x;

    Count3(int x) { _x = x; }

    public void run() {
        int temp, delay;
        for (int i = 0; i < 10; i++) {
            try {
                delay = (int) (10 * Math.random());
                Thread.sleep(delay);
                temp = n;
                delay = (int) (_x * Math.random());
                Thread.sleep(delay);
                n = temp + 1;
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The value of delay x is " + x);
        Count3 p = new Count3(x);
        Count3 q = new Count3(x);
        Count3 s = new Count3(x);
        p.start();
        q.start();
        s.start();
        try {
            p.join();
            q.join();
            s.join();
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n);
    }
}
