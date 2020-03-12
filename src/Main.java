import java.util.Random;

public class Main {

  public static void main(String[] args) {

      int clients = 50;

      Random rand = new Random();

      Paczkomat p1 = new Paczkomat(1);
      //Paczkomat p2 = new Paczkomat(2);
     // Paczkomat p3 = new Paczkomat(3);

      Runnable[] runnables1 = new Runnable[clients];
     // Runnable[] runnables2 = new Runnable[clients];
      //Runnable[] runnables3 = new Runnable[clients];

      Thread[] threads1 = new Thread[clients];
     // Thread[] threads2 = new Thread[clients];
      //Thread[] threads3 = new Thread[clients];

        for (int i = 0; i < clients; i++) {
          runnables1[i] = new Addressee(i,p1);
         // runnables2[i] = new Addressee(i,p2);
          //runnables3[i] = new Addressee(i,p3);
        }

      for (int i = 0; i < clients; i++) {
        threads1[i] = new Thread(runnables1[i]);
        //threads2[i] = new Thread(runnables2[i]);
        //threads3[i] = new Thread(runnables3[i]);
      }

      for (int i = 0; i < clients; i++) {
        try {
          threads1[i].start();
          Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

/*
        try {
          threads2[i].start();
          Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }


        try {
          threads3[i].start();
          Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
*/
      }

    for (int i = 0; i < clients; i++) {
      try {
        threads1[i].join();
        Thread.sleep(rand.nextInt(1000));
      } catch (Exception e) {
        e.printStackTrace();
      }
/*
      try {
        threads2[i].join();
        Thread.sleep(rand.nextInt(1000));
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        threads2[i].join();
        Thread.sleep(rand.nextInt(1000));
      } catch (Exception e) {
        e.printStackTrace();
        */
      }

    }

    }



