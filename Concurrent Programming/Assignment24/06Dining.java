package dining;

/**
 * Implementation of the Dining Philosopher's problem with a monitor for a
 * four-philosopher room.
 *
 * <p>Name: Frank Garcia 
 * <p>Date: 12/8/16
 * <p>Assignment: 24
 *
 * <p>File:
 * <code>Dining.java</code>
 *
 * @author Name
 */

public class Dining {

   public static void main(String[] args) {
      Trattoria trattoria = new Trattoria();
      Philosopher[] philosopher = new Philosopher[5];
       for (int i =0; i < 5; i++) {
           philosopher[i] = new Philosopher(i, trattoria);
           philosopher[i].start();
       }
       try {
           for (int i = 0; i < 5; i++) {
               philosopher[i].join();
           }
       } catch (InterruptedException e) {}
       System.out.println("The Philosophers are finished eating.\n");
   }
}
