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
 * <code>Philosopher.java</code>
 *
 * @author Name
 */

class Philosopher extends Thread {

   private int id;
   private Trattoria trattoria;

   Philosopher(int id, Trattoria trattoria) {
      this.id = id;
      this.trattoria = trattoria;
   }

   public void run() {
      int delay;
      System.out.println("Philosopher " + id + " started.");
      for (int i = 0; i < 3; i++) {
       try {
           trattoria.enterDiningRoom(id);
           trattoria.acquireFork(id, id);
           System.out.println("Philosopher " + id + " is going to sleep.");
           Thread.sleep(100);
           trattoria.acquireFork(id,(id + 1) % 5);
           System.out.println("Philosopher " + id + " is going to eat.");
           delay = (int) (100 * Math.random());
           Thread.sleep(delay);
           trattoria.releaseFork(id, id);
           trattoria.releaseFork(id, (id + 1) % 5);
           trattoria.exitDiningRoom(id);
           System.out.println("Philosopher " + id + " is going to think.");
           delay = (int) (100 * Math.random());
           Thread.sleep(delay);
       } catch (InterruptedException e) {}
      }
      System.out.println("Philosopher " + id + " finished.");
   }
}
