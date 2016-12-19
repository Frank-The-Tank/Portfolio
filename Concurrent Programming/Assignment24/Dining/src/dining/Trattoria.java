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
 * <code>Trattoria.java</code>
 *
 * @author Name
 */

class Trattoria {
   private boolean[] forkAcquired = { false, false, false, false, false };
   private int numInDining = 0;

   public synchronized void enterDiningRoom(int philID) {
       while (numInDining == 4) {
           try {
               wait();
           } catch (InterruptedException e) {}
       }
       numInDining++;
       System.out.println("Philosopher " + philID + " entered dining room.");
   }

   public synchronized void exitDiningRoom(int philID) {
      while (numInDining == 0) {
          try {
              wait();
          } catch (InterruptedException e) {}
      }
      numInDining--;
      System.out.println("Philosopher " + philID + " left dining room.");
      notifyAll();
   }

   public synchronized void acquireFork(int philID, int forkID) {
       while (forkAcquired[forkID]) {
           try {
               wait();
           } catch (InterruptedException e) {}
       }
      forkAcquired[forkID] = true;
      System.out.println("Philosopher " + philID + " picked up fork "
                         + forkID + ".");
   }

   public synchronized void releaseFork(int philID, int forkID) {
       while (forkAcquired[forkID] == false) {
           try {
               wait();
           } catch (InterruptedException e) {}
       }
      forkAcquired[forkID] = false;
      System.out.println("Philosopher " + philID + " put down fork " + forkID + ".");
      notifyAll();
   }
}
