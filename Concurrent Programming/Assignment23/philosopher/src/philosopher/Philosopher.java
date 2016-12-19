package philosopher;

/**
 * Implementation of the Dining Philosopher's problem with semaphores and a
 * four-philosopher room.
 *
 * <p>Name: Frank Garcia 
 * <p>Date: 12/5/16
 * <p>Assignment: 23
 *
 * <p>File:
 * <code>Philosopher.java</code>
 *
 * @author Name
 */
import java.util.concurrent.*;

public class Philosopher extends Thread {

    private int processID;
    private static Semaphore room = new Semaphore(4);
    private static Semaphore[] forks = new Semaphore[5];
    
    Philosopher(int pid) {
        processID = pid;
    }

    public void run() {
        int delay;
        for (int i = 0; i < 3; i++) {
            switch (processID) {
                case 0:
                   try {
                       System.out.println("Philosopher " + processID + " is thinking\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       room.acquire();
                       System.out.println("Philosopher " + processID + " entered the dinning room\n");
                       forks[i].acquire();
                       forks[i+1].acquire();
                       System.out.println("Philosopher " + processID + " is eating\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       forks[i].release();
                       forks[i+1].release();
                       room.release();
                       System.out.println("Philosopher " + processID + " left the dinning room\n");
                       break;
                   } catch (InterruptedException e) {}
                case 1:
                   try {
                       System.out.println("Philosopher " + processID + " is thinking\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       room.acquire();
                       System.out.println("Philosopher " + processID + " entered the dinning room\n");
                       forks[i].acquire();
                       forks[i+1].acquire();
                       System.out.println("Philosopher " + processID + " is eating\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       forks[i].release();
                       forks[i+1].release();
                       room.release();
                       System.out.println("Philosopher " + processID + " left the dinning room\n");
                       break;
                   } catch (InterruptedException e) {}
                case 2:
                    try {
                       System.out.println("Philosopher " + processID + " is thinking\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       room.acquire();
                       System.out.println("Philosopher " + processID + " entered the dinning room\n");
                       forks[i].acquire();
                       forks[i+1].acquire();
                       System.out.println("Philosopher " + processID + " is eating\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       forks[i].release();
                       forks[i+1].release();
                       room.release();
                       System.out.println("Philosopher " + processID + " left the dinning room\n");
                       break;
                   } catch (InterruptedException e) {}
                case 3:
                    try {
                       System.out.println("Philosopher " + processID + " is thinking\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       room.acquire();
                       System.out.println("Philosopher " + processID + " entered the dinning room\n");
                       forks[i].acquire();
                       forks[i+1].acquire();
                       System.out.println("Philosopher " + processID + " is eating\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       forks[i].release();
                       forks[i+1].release();
                       room.release();
                       System.out.println("Philosopher " + processID + " left the dinning room\n");
                       break;
                   } catch (InterruptedException e) {}
                case 4:
                    try {
                       System.out.println("Philosopher " + processID + " is thinking\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       room.acquire();
                       System.out.println("Philosopher " + processID + " entered the dinning room\n");
                       forks[i].acquire();
                       forks[i+1].acquire();
                       System.out.println("Philosopher " + processID + " is eating\n");
                       delay = (int) (100 * Math.random());
                       Thread.sleep(delay);
                       forks[i].release();
                       forks[i+1].release();
                       room.release();
                       System.out.println("Philosopher " + processID + " left the dinning room\n");
                       break;
                   } catch (InterruptedException e) {}
                default:
                    System.out.println("Switch statement did not hit valid processID");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int i;
        // In a loop, allocate the five fork semaphores initialized to 1,
        //    and with fair scheduling (second constructor parameter true).
        for(i = 0; i <= 4; i++) {
            forks[i] = new Semaphore(1, true);
        }
        // Allocate an array of five Philosopher processes.
        Philosopher[] philosophers = new Philosopher[5];
        // In a loop, allocate the five Philosopher processes with processID's
        //    0, 1, 2, 3, and 4.
        for(i = 0; i <= 4; i++) {
            philosophers[i] = new Philosopher(i);
        }
        // In a loop, start each philosopher process.
        for(i = 0; i <= 4; i++) {
            philosophers[i].start();
        }
        // In a loop within a try statement, join each philosopher process.
        try {
            for(i = 0; i <= 4; i++) {
                philosophers[i].join();
            }
        } catch (InterruptedException e) {} 
        System.out.println("The Philosophers are finished eating.\n");
    }
}
