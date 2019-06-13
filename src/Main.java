import java.util.Random;

public class Main {


    public static void main(String[] args) {

      Random rand = new Random();

      Paczkomat p = new Paczkomat(1);

      Runnable[] runnables = new Runnable[22];
      Thread[] threads = new Thread[22];

        for (int i = 0; i < 22; i++) {
          runnables[i] = new Addressee(i,p);
        }

      for (int i = 0; i < 22; i++) {
        threads[i] = new Thread(runnables[i]);
      }

      for (int i = 0; i < 22; i++) {
       threads[i].start();
        try {
          Thread.sleep(rand.nextInt(1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
}
